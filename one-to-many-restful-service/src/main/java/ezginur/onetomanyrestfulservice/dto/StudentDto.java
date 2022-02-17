package ezginur.onetomanyrestfulservice.dto;

import lombok.Data;
import ezginur.onetomanyrestfulservice.model.Student;


@Data
public class StudentDto {
    private Long id;
    private String name;
    private String surname;

    public static StudentDto from(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setSurname(student.getSurname());
        return studentDto;
    }
}
