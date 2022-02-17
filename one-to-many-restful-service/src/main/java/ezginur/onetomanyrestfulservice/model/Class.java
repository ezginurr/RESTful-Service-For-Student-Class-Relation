package ezginur.onetomanyrestfulservice.model;

import ezginur.onetomanyrestfulservice.dto.ClassDto;
import lombok.Data;
import javax.persistence.*; //entity, table, id, generatedValue,
import java.util.ArrayList;
import java.util.List;

@Data //do not need constructors
@Entity
@Table(name = "Class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "class_id")

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }

    public static Class from(ClassDto classDto){
        Class schoolClass = new Class();
        return schoolClass;
    }
}
