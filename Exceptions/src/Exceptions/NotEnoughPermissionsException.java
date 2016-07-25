package Exceptions;

/**
 * Created by codecadet on 24/05/16.
 */
public class NotEnoughPermissionsException extends FileException {

    public NotEnoughPermissionsException(String message) {
        super(message);
    }
}
