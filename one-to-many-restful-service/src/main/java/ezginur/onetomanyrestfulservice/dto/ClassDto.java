package ezginur.onetomanyrestfulservice.dto;

import ezginur.onetomanyrestfulservice.model.Student;
import ezginur.onetomanyrestfulservice.model.Class;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ClassDto {
    private Long id;
    private List<StudentDto> studentsDto = new ArrayList<>();

    public static ClassDto from(Class schoolClass){
        ClassDto classDto = new ClassDto();
        classDto.setId(schoolClass.getId());
        classDto.setStudentsDto(schoolClass.getStudents().stream().map(StudentDto::from).collect(Collectors.toList()));
        return classDto;
    }
}
