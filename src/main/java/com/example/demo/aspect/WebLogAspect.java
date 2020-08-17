
package com.example.demo.aspect;


import cn.hutool.json.JSONUtil;


import com.alibaba.fastjson.JSON;
import com.mzlion.core.http.IPUtils;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;



/**
 * @author lyc
 * @link https://www.cnblogs.com/bigben0123/p/7779357.html
 *
 * 我们需要定义每个切面的优先级，我们需要@Order(i)注解来标识切面的优先级。i的值越小，优先级越高
 * @date 2020/6/18
 */

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
            String contentType = request.getHeader("content-type");
            if(contentType != null && contentType.toLowerCase().indexOf(MediaType.APPLICATION_JSON_VALUE) !=-1){
                logger.info("parameters : {}", JSONUtil.toJsonStr(pjp.getArgs()));
            }
            logger.info("content-type:{}",  request.getHeader("content-type"));
            logger.info("request ip:{}", IPUtils.getClientIp(request));
            logger.info("http_method : {}", request.getMethod());
            logger.info("uri : {}", request.getRequestURI());
            Map<String, String[]> parameterMap = request.getParameterMap();
            logger.info("parameterMap : {}", JSONUtil.toJsonStr(parameterMap));

            logger.info("parameters :{}",JSONUtil.toJsonStr(getRequestParams(pjp)));

            // 阿里 的序列化 response 有问题 会导致 下载 getOutputStream() has already been called for this response
            //logger.info("parameters : {}", JSON.toJSONString(pjp.getArgs()));
            //方便查找那台服务器报错
            InetAddress addr = InetAddress.getLocalHost();
            String ip = addr.getHostAddress().toString();
            String hostName = addr.getHostName().toString();
          /*  SysUserEntity currentSysUser = SubjectUtils.getCurrentSysUser();
            if (currentSysUser != null) {
                logger.info("username : {} ", currentSysUser.getUsername());
            } else {
                logger.info("username : {} ", "");
            }*/
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

    /**
     * 获取入参
     * @param proceedingJoinPoint
     *
     * @return
     * */
    private Map<String, Object> getRequestParams(ProceedingJoinPoint proceedingJoinPoint) {
        Map<String, Object> requestParams = new HashMap<>();

        //参数名
        String[] paramNames =
                ((MethodSignature)proceedingJoinPoint.getSignature()).getParameterNames();
        //参数值
        Object[] paramValues = proceedingJoinPoint.getArgs();

        for (int i = 0; i < paramNames.length; i++) {
            Object value = paramValues[i];

            //如果是文件对象
            if (value instanceof MultipartFile) {
                MultipartFile file = (MultipartFile) value;
                value = file.getOriginalFilename();  //获取文件名
            }

            requestParams.put(paramNames[i], value);
        }

        return requestParams;
    }

}
