package cn.chunhuitech.www.api.common.model;
import org.apache.http.HttpStatus;
/**
 * Created by hechengjin on 17-8-2.
 */
public final class ErrorCode {

    private static ErrorMessage addErrorMsg(Integer code, String result, Integer httpStatus) {
        return ErrorMessage.create(code, result, httpStatus);
    }

    //success
    public static final ErrorMessage SUCCESS = addErrorMsg(0, "SUCCESS. ", HttpStatus.SC_OK);

    //unknown
    public static final ErrorMessage UNKNOWN = addErrorMsg(900000, "Unknown error. ", HttpStatus.SC_INTERNAL_SERVER_ERROR);

    //illegal argument
    public static final ErrorMessage ILLEGAL_ARGUMENT = addErrorMsg(900001, "Illegal Argument. ", HttpStatus.SC_BAD_REQUEST);

    //db error
    public static final ErrorMessage DB_ERROR = addErrorMsg(900002, "DB Error.(Maybe field is null...) ", HttpStatus.SC_BAD_REQUEST);

    //argument type error
    public static final ErrorMessage ARGUMENT_TYPE_ERROR = addErrorMsg(900003, "argument type error. ", HttpStatus.SC_BAD_REQUEST);

    //Internal error
    public static final ErrorMessage INTERNAL_ERROR = addErrorMsg(900004, "Bad Request internal error. ", HttpStatus.SC_BAD_REQUEST);

    //Arithmetic error
    public static final ErrorMessage ARITHMETIC_ERROR = addErrorMsg(900005, "arithmetic error. ", HttpStatus.SC_BAD_REQUEST);

    //Integrity 完整性 Constraint 约束 Violation 违反 Exception
    public static final ErrorMessage DATA_INTEGRITY_CONSTRAINT_EXCEPTION = addErrorMsg(900006, "数据完整性约束异常. ", HttpStatus.SC_BAD_REQUEST);

    //唯一键重复
    public static final ErrorMessage DUPLICATE_KEY_EXCEPTION = addErrorMsg(900007, "唯一键重复. ", HttpStatus.SC_BAD_REQUEST);

    //illegal empty
    public static final ErrorMessage ILLEGAL_EMPTY = addErrorMsg(900008, "The parameter is empty. ", HttpStatus.SC_BAD_REQUEST);

    public static final ErrorMessage USER_NOT_EXIST = addErrorMsg(900009, "user does not exist. ", HttpStatus.SC_BAD_REQUEST);

    public static final ErrorMessage USER_PASSWORD_ERROR = addErrorMsg(900010, "user password error. ", HttpStatus.SC_BAD_REQUEST);

    /**
     * 记录占用Record is occupied
     */
    public static final ErrorMessage DB_ERROR_OCCUPIED = addErrorMsg(900011, "Record is occupied", HttpStatus.SC_BAD_REQUEST);

    public static final ErrorMessage WARN_TOO_MAX_COUNT = addErrorMsg(900012, "The number of records is too large", HttpStatus.SC_BAD_REQUEST);

    public static final ErrorMessage EXCEPTION_REQUEST_SOURCE = addErrorMsg(900013, "request source error.", HttpStatus.SC_BAD_REQUEST);

    public static final ErrorMessage EXCEPTION_PARAM_INVALID = addErrorMsg(900014, "request param error.", HttpStatus.SC_BAD_REQUEST);

    public static final ErrorMessage EXCEPTION_SIGN_INVALID = addErrorMsg(900015, "request sign error.", HttpStatus.SC_BAD_REQUEST);

    public static final ErrorMessage EXCEPTION_TOKEN_ERROR = addErrorMsg(900016, "token error.", HttpStatus.SC_BAD_REQUEST);

    public static final ErrorMessage EXCEPTION_TOKEN_NOT_FIND = addErrorMsg(900017, "token not find error.", HttpStatus.SC_BAD_REQUEST);

    public static final ErrorMessage RECORD_HAS_SUBDATA = addErrorMsg(900018, "Data under classification.", HttpStatus.SC_OK);

}
