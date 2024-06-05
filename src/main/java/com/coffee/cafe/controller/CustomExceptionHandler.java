package com.coffee.cafe.controller;

import com.coffee.cafe.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView Exception(Exception ex) {
        ModelAndView mav = new ModelAndView("/generic_error");
        mav.addObject("exception", ex);
        return mav;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView EntityNotFoundException(EntityNotFoundException ex) {
        ModelAndView mav = new ModelAndView("/not_found");
        mav.addObject("message", ex.getMessage());
        return mav;
    }
}
