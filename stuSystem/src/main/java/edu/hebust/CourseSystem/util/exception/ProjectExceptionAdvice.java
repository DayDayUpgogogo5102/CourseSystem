package edu.hebust.CourseSystem.util.exception;

import edu.hebust.CourseSystem.util.result.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProjectExceptionAdvice {


    @ExceptionHandler(Exception.class)
    public R printErr(){
        return new R(true,"出现自定义异常",null);
    }
}
