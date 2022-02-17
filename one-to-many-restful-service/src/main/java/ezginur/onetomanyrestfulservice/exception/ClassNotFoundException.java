package ezginur.onetomanyrestfulservice.exception;

import java.text.MessageFormat;

public class ClassNotFoundException extends RuntimeException{
    public ClassNotFoundException(final Long id){
        super(MessageFormat.format("Could not find class with id: {0}", id));
    }
}
