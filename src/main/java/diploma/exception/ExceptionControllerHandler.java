package diploma.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.exceptions.TemplateProcessingException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionControllerHandler {


    @ExceptionHandler(TemplateProcessingException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
     ModelAndView IndexOutOfBoundException(HttpServletRequest  request, TemplateProcessingException exception){
        ModelAndView modelAndView = new ModelAndView("not_found");
        modelAndView.addObject("code",HttpStatus.NOT_FOUND.value()+"\t"+ HttpStatus.NOT_FOUND.getReasonPhrase());
        modelAndView.addObject("message",exception.getMessage());
        return modelAndView;

    }



}
