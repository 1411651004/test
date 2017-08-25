package com.example.demo.handle;

import com.example.demo.pojo.Result;
import com.example.demo.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gzf on 2017/8/13.
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public     Result handle(Exception e){
        return ResultUtils.error(100,e.getMessage());
    }
}
