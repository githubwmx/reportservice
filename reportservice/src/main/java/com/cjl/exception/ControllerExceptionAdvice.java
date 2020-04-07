package com.cjl.exception;

import com.cjl.util.BusinessException;
import com.cjl.util.Result;
import com.cjl.util.ResultConstant;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class ControllerExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public Result errorHandler(Exception ex) {
        return ResultConstant.createErrorMessage(ex.getMessage());
    }

}
