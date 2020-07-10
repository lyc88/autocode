/*
package com.example.demo.aspect;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.zt.common.utils.IPUtils;
import com.zt.common.utils.SubjectUtils;
import com.zt.modules.sys.entity.SysUserEntity;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Map;


*/
/**
 * @author lyc
 * @link https://www.cnblogs.com/bigben0123/p/7779357.html
 *
 * 我们需要定义每个切面的优先级，我们需要@Order(i)注解来标识切面的优先级。i的值越小，优先级越高
 * @date 2020/6/18
 *//*

@Aspect
@Component
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    //@Pointcut("execution(public * com.zt.modules..controller..*(..))")
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController ) || @within(org.springframework.stereotype.Controller)")
    public void webLog(){}

    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {
        Long start = System.currentTimeMillis();
        try {
            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

            HttpServletRequest request = attributes.getRequest();
            String ua = request.getHeader("User-Agent");
            UserAgent userAgent = UserAgent.parseUserAgentString(ua);
            Browser browser = userAgent.getBrowser();
            OperatingSystem os = userAgent.getOperatingSystem();
            String system = os.getName();
            String browserName = browser.getName();

            logger.info("browser:{} system:{}", browserName,system);

            logger.info("request ip:{}", IPUtils.getIpAddr(request));
            logger.info("http_method : {}", request.getMethod());
            logger.info("uri : {}", request.getRequestURI());
            Map<String, String[]> parameterMap = request.getParameterMap();
            logger.info("parameterMap : {}", JSON.toJSONString(parameterMap));

            //方便查找那台服务器报错
            InetAddress addr = InetAddress.getLocalHost();
            String ip = addr.getHostAddress().toString();
            String hostName = addr.getHostName().toString();
            SysUserEntity currentSysUser = SubjectUtils.getCurrentSysUser();
            if (currentSysUser != null) {
                logger.info("username : {} ", currentSysUser.getUsername());
            } else {
                logger.info("username : {} ", "");
            }
            logger.info("host : {} ip {}", hostName, ip);
            //logger.info("class_method : {},{}" , pjp.getSignature().getDeclaringTypeName() ,pjp.getSignature().getName());

            Object result = pjp.proceed();
            logger.info("success response :" + JSONUtil.parse(result));
            return result;
        } catch (Throwable e) {
            logger.info("error info :{}", ExceptionUtils.getMessage(e));
            throw e;
        } finally {
            Long end = System.currentTimeMillis();
            logger.info("耗时:{}秒", (end - start) / 1000);
        }
    }
}*/
