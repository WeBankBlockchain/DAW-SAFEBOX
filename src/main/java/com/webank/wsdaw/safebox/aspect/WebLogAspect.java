package com.webank.wsdaw.safebox.aspect;

import cn.hutool.json.JSONUtil;
import com.webank.wsdaw.safebox.enums.CodeEnum;
import com.webank.wsdaw.safebox.monitor.MonitorEntry;
import com.webank.wsdaw.safebox.monitor.MonitorUtil;
import com.webank.wsdaw.safebox.vo.response.CommonResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Around("execution(* com.webank.wsdaw.safebox.controller.*.*(..))")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            CommonResponse result = (CommonResponse) proceedingJoinPoint.proceed();
            MonitorEntry monitorEntry =
                    new MonitorEntry(
                            proceedingJoinPoint.getSignature().getName(),
                            null,
                            String.valueOf(result.getCode()),
                            result.getMsg(),
                            System.currentTimeMillis() - startTime);
            MonitorUtil.getMonitorLogger().info("[{}]", JSONUtil.toJsonStr(monitorEntry));
            return result;
        } catch (Exception e) {
            CodeEnum codeEnum = CodeEnum.UNKNOWN_ERROR;
            MonitorEntry monitorEntry =
                    new MonitorEntry(
                            proceedingJoinPoint.getSignature().getName(),
                            null,
                            String.valueOf(codeEnum.getCode()),
                            codeEnum.getMsg(),
                            System.currentTimeMillis() - startTime);
            MonitorUtil.getMonitorLogger().info("[{}]", JSONUtil.toJsonStr(monitorEntry));
            throw e;
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.webank.wsdaw.safebox.controller.*.*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object[] params = joinPoint.getArgs();
        log.info(
                "Returning from={} path={} method={} classMethod={} result={} params={}",
                request.getRemoteAddr(),
                request.getRequestURI(),
                request.getMethod(),
                joinPoint.getSignature().getDeclaringTypeName()
                        + "."
                        + joinPoint.getSignature().getName(),
                params,
                result);
    }
}
