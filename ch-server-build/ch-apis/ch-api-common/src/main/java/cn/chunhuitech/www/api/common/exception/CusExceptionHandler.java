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

    @ExceptionHandler(RequestSourceException.class)
    @ResponseBody
    public ResponseEntity<Object> RequestSourceExceptionHandler(Exception ex) {
        logger.error("request source error:", ex);
        return excHandleResponse(ErrorCode.EXCEPTION_REQUEST_SOURCE, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ParamInvalidException.class)
    @ResponseBody
    public ResponseEntity<Object> ParamInvalidExceptionHandler(Exception ex) {
        logger.error("request param error:", ex);
        return excHandleResponse(ErrorCode.EXCEPTION_PARAM_INVALID, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TokenErrorException.class)
    @ResponseBody
    public ResponseEntity<Object> TokenErrorExceptionHandler(Exception ex) {
        logger.error("token error:", ex);
        return excHandleResponse(ErrorCode.EXCEPTION_TOKEN_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TokenNotFindException.class)
    @ResponseBody
    public ResponseEntity<Object> TokenNotFindExceptionHandler(Exception ex) {
        logger.error("token not find:", ex);
        return excHandleResponse(ErrorCode.EXCEPTION_TOKEN_NOT_FIND, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @ExceptionHandler(SignException.class)
    @ResponseBody
    public ResponseEntity<Object> SignExceptionHandler(Exception ex) {
        logger.error("request sign error:", ex);
        return excHandleResponse(ErrorCode.EXCEPTION_SIGN_INVALID, HttpStatus.INTERNAL_SERVER_ERROR);
    }

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
