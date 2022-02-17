package ezginur.onetomanyrestfulservice.model;

import lombok.Data;
import ezginur.onetomanyrestfulservice.dto.StudentDto;
import javax.persistence.*; //entity, table, id, generatedValue,

@Data //do not need constructors
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name = "student_id")
    private String name;
    @JoinColumn(name = "student_name")
    private String surname;
    @JoinColumn(name = "student_surname")

    @ManyToOne

    public static Student from(StudentDto studentDto){
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        return student;
    }
}
