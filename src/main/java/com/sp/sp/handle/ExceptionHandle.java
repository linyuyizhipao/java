package com.sp.sp.handle;

import com.sp.sp.dto.CommonResult;
import com.sp.sp.exception.SpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hugo
 * 全局异常类执行handle，我们在exception里面定义了自己的异常
 * 那么在我们的业务里面就可以使用我们自己定义的SpException去抛出我们自己的异常
 * 继而我们就可以在这里拦截所有的异常，然后加以判断识别，当发现使我们自己自定义的异常对象，就可以识别出来，做自己的特殊处理
 * 比如说这里我是为了统一web端的json数据格式输出
 * 2020-01-21 13:59
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult handle(Exception e) {
        if (e instanceof SpException) {
            SpException spException = (SpException) e;
            return new CommonResult().exception(spException.getCode(), spException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return new CommonResult().failed();
        }
    }
}
