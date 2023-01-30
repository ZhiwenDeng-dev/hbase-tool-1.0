package com.github.zhiwen.exception;

/**
 * @author: zhiwen.deng@shopee.com
 * @date: 2023/01/30/ 6:44 PM
 * @Description: TODO
 */
public class HBaseOperationsException  extends RuntimeException{
    private static final long serialVersionUID = 0L;

    public HBaseOperationsException() {
        super();
    }

    public HBaseOperationsException(String message) {
        super(message);
    }

    public HBaseOperationsException(Throwable cause) {
        super(cause);
    }

    public HBaseOperationsException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
