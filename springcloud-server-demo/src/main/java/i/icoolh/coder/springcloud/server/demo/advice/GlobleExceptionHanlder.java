package i.icoolh.coder.springcloud.server.demo.advice;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Author icoolh
 * @Date 2019/8/5 16:28
 **/
@ControllerAdvice
public class GlobleExceptionHanlder {

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public String nonPermissions(AccessDeniedException e){
        System.out.println(e.getMessage());
        return "无权访问";
    }

    //声明要捕获的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defultExcepitonHandler(HttpServletRequest request, Exception e) {
	    return "error";
    }

}
