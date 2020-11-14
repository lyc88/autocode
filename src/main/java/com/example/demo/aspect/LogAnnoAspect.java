package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author lyc
 * @date 2020/11/14 9:22
 * @describe https://www.jianshu.com/p/14e54863faae
 */
@Component
@Slf4j
@Aspect
public class LogAnnoAspect implements BeanFactoryAware {
    //定义解析的模板
    private static final TemplateParserContext PARSER_CONTEXT = new TemplateParserContext();
    //定义解析器
    private static final SpelExpressionParser PARSER = new SpelExpressionParser();
    //定义评估的上下文对象
    private final StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
    //获取到Spring容器的beanFactory对象
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        //填充evaluationContext对象的`BeanFactoryResolver`。
        this.evaluationContext.setBeanResolver(new BeanFactoryResolver(beanFactory));
    }
    @Pointcut("@annotation(com.example.demo.aspect.LogAnno)")
    public void permission() {
    }
    @Around(value = "permission();")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        //参数值
        Object[] args = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) signature;
        Object target = joinPoint.getTarget();
        //获取到当前执行的方法
        Method method = target.getClass().getDeclaredMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        //获取方法的注解
        Object proceed = joinPoint.proceed();
        LogAnno logAnno = method.getAnnotation(LogAnno.class);
        /**
         * 1. resolve(logAnno.typeExpression()得到的值为：#{@ELService.x(#root)}。
         * 2. parseExpression解析后得到实际字符串为@ELService.x(#root)表达式。
         * 3. getValue去bean容器中执行ELService类的x方法。当然参数是context的#root对象。通过proceed传入。
         * 4. 最终返回的类型为method.getReturnType()原方法的类型
         */
        return PARSER.parseExpression(resolve(logAnno.typeExpression()), PARSER_CONTEXT)
                .getValue(this.evaluationContext, proceed, method.getReturnType());
    }

    /**
     * 作用是读取yml里面的值
     *
     * @param value 例如：1. #{${ttt.xxx}}会读取yml的ttt.xxx: read配置值，替换为#{read}
     *                   2.#{read}直接返回#{read}
     * @return #{read}
     */
    private String resolve(String value) {
        if (this.beanFactory != null && this.beanFactory instanceof ConfigurableBeanFactory) {
            return ((ConfigurableBeanFactory) this.beanFactory).resolveEmbeddedValue(value);
        }
        return value;
    }
}