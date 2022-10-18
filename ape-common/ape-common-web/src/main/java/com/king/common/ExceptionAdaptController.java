package com.king.common;

import com.king.bean.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @RestControllerAdvice的特点：
 *
 * 通过@ControllerAdvice注解可以将对于控制器的全局配置放在同一个位置。
 * 注解了@RestControllerAdvice的类的方法可以使用@ExceptionHandler、@InitBinder、@ModelAttribute注解到方法上。
 * @RestControllerAdvice注解将作用在所有注解了@RequestMapping的控制器的方法上。
 * @ExceptionHandler：用于指定异常处理方法。当与@RestControllerAdvice配合使用时，用于全局处理控制器里的异常。
 * @InitBinder：用来设置WebDataBinder，用于自动绑定前台请求参数到Model中。
 * @ModelAttribute：本来作用是绑定键值对到Model中，当与@ControllerAdvice配合使用时，可以让全局的@RequestMapping都能获得在此处设置的键值对
 *
 *
 * 全局异常处理
 *
 */
@RestControllerAdvice
public class ExceptionAdaptController {


    /**
     * 运行时异常
     * @param exception
     * @return
     */
    @ExceptionHandler({RuntimeException.class})
    public Result runTimeException(RuntimeException exception){
        exception.printStackTrace();
        return Result.fail();
    }


    /**
     * 全局异常
     * @param exception
     * @return
     */
    @ExceptionHandler({Exception.class})
    public Result exception(Exception exception){
        exception.printStackTrace();
        return Result.fail();
    }

}
