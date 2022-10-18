package exception;


/**
 * 加锁异常
 */
public class ShareLockException extends RuntimeException{

    public ShareLockException(String message){
        super(message);
    }

}
