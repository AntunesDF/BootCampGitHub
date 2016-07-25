package Exceptions;

/**
 * Created by codecadet on 24/05/16.
 */
public class NotEnoughSpaceException extends FileException {

    public NotEnoughSpaceException(String message) {
        super(message);
    }
}
