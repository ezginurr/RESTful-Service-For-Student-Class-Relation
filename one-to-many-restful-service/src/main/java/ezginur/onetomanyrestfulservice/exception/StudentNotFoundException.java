package ezginur.onetomanyrestfulservice.exception;
import java.text.MessageFormat;
public class StudentNotFoundException extends RuntimeException{
    public  StudentNotFoundException(final Long id){
        super(MessageFormat.format("Could not find student with id: {0}", id));
    }
}
