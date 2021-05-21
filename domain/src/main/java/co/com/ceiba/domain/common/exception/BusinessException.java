package co.com.ceiba.domain.common.exception;

public class BusinessException extends RuntimeException {

    private final int code;

    public BusinessException(String s, int code) {
        super(s);
        this.code = code;
    }

}
