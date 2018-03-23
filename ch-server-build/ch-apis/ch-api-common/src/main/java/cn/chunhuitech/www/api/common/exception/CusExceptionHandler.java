package cn.chunhuitech.www.api.common.exception;

import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by hechengjin on 18-3-14.
 */
@ControllerAdvice
public class CusExceptionHandler extends ResponseEntityExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handleExceptionHandler(Exception ex) {
        logger.error("unknown error:", ex);
        return excHandleResponse(ErrorCode.UNKNOWN, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseEntity<Object> dataIntegrityViolationExceptionHandler(Exception ex) {
        logger.error("dataIntegrityViolationExceptionHandler:", ex);
        return excHandleResponse(ErrorCode.DB_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /////////////////////
    private ResponseEntity<Object> excHandleResponse(ErrorMessage errorMessage, HttpStatus status) {
        return excHandleResponse(errorMessage, null, status);
    }


    private ResponseEntity<Object> excHandleResponse(ErrorMessage errorMessage, HttpHeaders headers, HttpStatus status) {
        return new ResponseEntity<>(errorMessage, headers, status);

    }
}
