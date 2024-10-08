package com.webank.wsdaw.safebox.advice;

import com.webank.wsdaw.safebox.enums.CodeEnum;
import com.webank.wsdaw.safebox.vo.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalAdvice {

    @ExceptionHandler({Exception.class})
    public CommonResponse unhandledException(Exception ex) {
        log.error("unhandled exception", ex);
        return CommonResponse.error(CodeEnum.UNKNOWN_ERROR);
    }
}
