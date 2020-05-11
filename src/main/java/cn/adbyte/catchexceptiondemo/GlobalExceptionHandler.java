package cn.adbyte.catchexceptiondemo;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ClassUtils;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.thymeleaf.exceptions.TemplateEngineException;
import org.thymeleaf.exceptions.TemplateInputException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

/**
 * @author Adam
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler{


    @ExceptionHandler(ClientAbortException.class)
    public void clientAbortExceptionHandler(HttpServletRequest request, ClientAbortException e) {
        String username = "<NONE>";
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            username = principal.getName();
        }
        log.warn("ClientAbortException: username={},remoteAddr={},userAgent={},requestedURL={}", username,
                request.getRemoteAddr(), request.getHeader("User-Agent"), request.getRequestURL());
    }

}