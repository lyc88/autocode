### 在Spring Boot Maven POM文件中加入
~~~
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
~~~
还有其它的Pom可以自行添加，下面主要是配置。

### WebSecurityConfig类的源代码如下：

~~~
package com.zxstrive.fight.sys.config;

import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.zxstrive.fight.sys.extend.security.CustomAccessDeniedHandler;
import com.zxstrive.fight.sys.extend.security.CustomAuthenticationFailureHandler;
import com.zxstrive.fight.sys.extend.security.CustomAuthenticationProcessingFilter;
import com.zxstrive.fight.sys.extend.security.CustomAuthenticationSuccessHandler;
import com.zxstrive.fight.sys.extend.security.CustomLogoutHandler;
import com.zxstrive.fight.sys.extend.security.CustomUserDetailsService;
import com.zxstrive.fight.sys.extend.security.UnauthorizedEntryPoint;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    //自动注入认证管理器
	@Autowired
	private AuthenticationManager authenticationManager;
	
    //向Spring容器中加入自定义认证失败处理，可以自由处理同步或异步返回
	@Bean
	public CustomAuthenticationFailureHandler failureHandler() {
		return new CustomAuthenticationFailureHandler();
	}
	
    //向Spring容器中加入自定义认证成功处理器，也是为了能够同时处理同步和异步登录
	@Bean
	public CustomAuthenticationSuccessHandler successHandler() {
		return new CustomAuthenticationSuccessHandler();
	}
	
    //自己登录拒绝处理器，一般是无权访问时执行
	@Bean
	public CustomAccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
    //自定义认证过程中的过滤器，这里加入了验证码过滤，后面会有源码
	@Bean
	public CustomAuthenticationProcessingFilter captchaProcessingFilter() {
		CustomAuthenticationProcessingFilter captchaProcessingFilter = new CustomAuthenticationProcessingFilter();
		captchaProcessingFilter.setAuthenticationFailureHandler(failureHandler());
		captchaProcessingFilter.setAuthenticationManager(authenticationManager);
		return captchaProcessingFilter;
	}
	
    //加载自定义用户信息服务，即自定义UserDetailsService，后面会给出介绍
	@Bean
	@Qualifier("localUserDetailsService")
	public UserDetailsService localUserDetailsService(){
		return new CustomUserDetailsService();
	}

    //这里是核心配置
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		/**
		 * 加入验证码过滤功能,将验证码过滤器添加到用户名密码认证之前
		 */
		http.addFilterBefore(captchaProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
		
		
		/**
		 * http 登录配置
		 */
		http
			.authorizeRequests()
			.antMatchers("/admin/**")    //本系统所有以/admin开头的请求都会被安全策略拦截，其它路径请求通过
			.authenticated()
			.anyRequest()
			.permitAll()
		.and()
			.formLogin()
			.loginPage("/login")   //指定登录页面，这个/login是通过Spring MVC路径，将返回登录页面视图
			.loginProcessingUrl("/loginProcess") //同理，登录请求，也就是登录表单中的action。
			.failureHandler(failureHandler()) //添加登录失败处理器
			.permitAll()
			.usernameParameter("loginName")   //登录提交认证的用户名的参数名
			.passwordParameter("password")    //登录提交认证的密码的请求参数名
			.successHandler(successHandler()) //成功处理器
		.and()
			.exceptionHandling()  //异常处理
			.accessDeniedHandler(accessDeniedHandler())   //拒绝请求处理
			.authenticationEntryPoint(new UnauthorizedEntryPoint())    //自定义的未授权异常处理
		.and()
			.logout()
			.logoutUrl("/logout")    //注销地址
			.logoutSuccessHandler(new CustomLogoutHandler())   //注销成功处理
			.permitAll()
		.and()
			.rememberMe()
			.tokenValiditySeconds(3600 * 24 * 7)
			.rememberMeCookieName("authentication")
			.rememberMeParameter("rememberMe")
			.key("fight")    //以上是SpringSecurity记住我规则，使用Cookie记住一周时间，key为cookie键名
		.and()   //此处配置同源策略
			.headers()
			.frameOptions()
			.sameOrigin()
		.and()    //此处配置csrf
			.csrf()
			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
			.httpBasic()
		.and() //此处配置Session数量，如果登录超过2个，则另一个被退出，被退出跳到/login?expired页面，并提示
			.sessionManagement()
			.maximumSessions(1)
			.expiredUrl("/login?expired");
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(localUserDetailsService())    //注入自定义UserDetailsService
			.passwordEncoder(new PasswordEncoder() {    //自定义密码认证规则

				@Override
				public String encode(CharSequence rawPassword) {
					return rawPassword.toString();
				}

				@Override
				public boolean matches(CharSequence rawPassword, String encodedPassword) {
					rawPassword = Md5Crypt.md5Crypt(String.valueOf(rawPassword).getBytes(), "$1$fight$");
					return rawPassword.equals(encodedPassword);//比对加密后的算法为true认证成功
				}
				
			});
	}
	
}
~~~


### 自定义UserDetails
~~~
package com.zxstrive.fight.sys.extend.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.zxstrive.fight.app.entity.jpa.UserEntity;

public class UserDetailsBean implements UserDetails {

	private static final long serialVersionUID = 1L;
	
    //系统定义的User表
	private UserEntity user = new UserEntity();
	
    //角色列表
	private List<GrantedAuthority> authorities;
	
	public UserDetailsBean() {}
	
	public UserDetailsBean(String loginName, String password) {
		this.user.setLoginName(loginName);
		this.user.setPassword(password);
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getLoginName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public void setUsername(String username) {
		this.user.setLoginName(username);
	}
	
	public void setPassword(String password) {
		this.user.setPassword(password);
	}
	
	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public boolean equals(Object obj) {
		UserDetailsBean u = (UserDetailsBean)obj;
		return this.toString().equals(u.toString());
	}
	
	@Override
	public int hashCode() {
		return this.user.getLoginName().hashCode();
	}
	
	@Override
	public String toString() {
		return this.user.getLoginName();
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}	
	
}
~~~

### 自定义 UserDetailsService
~~~
package com.zxstrive.fight.sys.extend.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zxstrive.fight.app.dao.jpa.UserRepo;
import com.zxstrive.fight.app.entity.jpa.UserEntity;
import com.zxstrive.fight.sys.utils.StringUtils;

public class CustomUserDetailsService implements UserDetailsService {
	
    //Jpa Repository
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserDetailsBean user = new UserDetailsBean();
		List<UserEntity> users = userRepo.findByLoginName(userName);
		if(users != null && users.size() == 1) {
			user.setUser(users.get(0));
		}
		List<GrantedAuthority> grants = new ArrayList<GrantedAuthority>();
		grants.add(new SimpleGrantedAuthority("ROLE_USER"));
		user.setAuthorities(grants);
		return user;
	}

}
~~~

### 自定义 AccessDeniedHandler 自定义登录过期，或无权访问的处理器

~~~
package com.zxstrive.fight.sys.extend.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import net.sf.json.JSONObject;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		String requestType = request.getHeader("X-Requested-With");
		if("XMLHttpRequest".equalsIgnoreCase(requestType)) {
			try (PrintWriter out = response.getWriter()){
				JSONObject json = new JSONObject();
				json.element("status", "error");
				json.element("message", "您无权访问");
				out.write(json.toString());
				out.flush();
				out.close();
			}catch(Exception e) {}
		}else {
			response.sendRedirect(request.getContextPath()+"/login?denied");
		}

	}

}
~~~

### 自定义自定义认证失败处理器

~~~
package com.zxstrive.fight.sys.extend.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import net.sf.json.JSONObject;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	/**
	 * 定义失败类型,captcha为验证码失败,否则其它失败
	 */
	private String type;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		String requestType = request.getHeader("X-Requested-With");
		if("XMLHttpRequest".equalsIgnoreCase(requestType)) {
			try (PrintWriter out = response.getWriter()){
				JSONObject json = new JSONObject();
				json.element("status", "error");
				if("captcha".equals(type)) {
					json.element("message", "验证码不正确");
				}else {
					json.element("message", "用户名或密码不正确");
				}
				out.write(json.toString());
				out.flush();
				out.close();
			}catch(Exception e) {
				 
			}
		}else {
			if("captcha".equals(type)) {
				response.sendRedirect(request.getContextPath()+"/login?captcha");
			}else {
				response.sendRedirect(request.getContextPath()+"/login?error");
			}
		}
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
~~~

### 自定义认证处理过滤器，本自定义过滤器主要实现验证码过滤
~~~
package com.zxstrive.fight.sys.extend.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class CustomAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {
	
	public CustomAuthenticationProcessingFilter() {
		super(new AntPathRequestMatcher("/loginProcess", "POST"));
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		CustomAuthenticationFailureHandler customFailedHandler = (CustomAuthenticationFailureHandler)this.getFailureHandler();

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		if (!requiresAuthentication(request, response)) {
			chain.doFilter(request, response);
			return;
		}
		
		String captcha = request.getParameter("captcha");
		String captchaId = (String) request.getSession().getAttribute("captcha");
		if(captcha == null || !captcha.equalsIgnoreCase(captchaId)) {
			customFailedHandler.setType("captcha");//向failureHandler报告验证码错误
			this.unsuccessfulAuthentication(request, response, new InsufficientAuthenticationException("验证码不正确"));
			return;
		}else {
			customFailedHandler.setType(null);
			chain.doFilter(request, response);
			return;
		}

	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		return null;
	}
	
}
~~~

#### 自定义自定义认证成功处理器
~~~
package com.zxstrive.fight.sys.extend.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.DefaultCsrfToken;

import net.sf.json.JSONObject;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		DefaultCsrfToken _csrf = (DefaultCsrfToken) request.getAttribute("_csrf");
		String requestType = request.getHeader("X-Requested-With");
		if("XMLHttpRequest".equalsIgnoreCase(requestType)) {
			UserDetailsBean udb = (UserDetailsBean) authentication.getPrincipal();
			try (PrintWriter out = response.getWriter()){
				JSONObject json = new JSONObject();
				json.element("status", "success");
				json.element("obj", udb.getUser());
				json.element("_csrf", _csrf.getToken());
				out.write(json.toString());
				out.flush();
				out.close();
			}catch(Exception e) {
				 
			}
		}else {
			response.sendRedirect(request.getContextPath());
		}
	}

}
~~~

### 自定义注销处理器

~~~
package com.zxstrive.fight.sys.extend.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.DefaultCsrfToken;

import net.sf.json.JSONObject;

public class CustomLogoutHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		DefaultCsrfToken _csrf = (DefaultCsrfToken) request.getAttribute("_csrf");
		String requestType = request.getHeader("X-Requested-With");
		if("XMLHttpRequest".equalsIgnoreCase(requestType)) {
			try (PrintWriter out = response.getWriter()){
				JSONObject json = new JSONObject();
				json.element("status", "success");
				json.element("_csrf", _csrf.getToken());
				out.write(json.toString());
				out.flush();
				out.close();
			}catch(Exception e) {
				 
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/");
		}
	}

}
~~~

### 自定义认证异常处理器 如回话过期等

~~~
package com.zxstrive.fight.sys.extend.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import net.sf.json.JSONObject;

public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		String requestType = request.getHeader("X-Requested-With");
		if("XMLHttpRequest".equalsIgnoreCase(requestType)) {
			JSONObject json = new JSONObject();
			if(authException instanceof InsufficientAuthenticationException) {
				try(
						PrintWriter out = response.getWriter()){
					json.element("status", "warning");
					json.element("message", "您尚未登录，请登录后再操作");
					out.write(json.toString());
					out.flush();
					out.close();
				}catch(Exception e) {}
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/login?denied");
		}
		
	}

}
~~~