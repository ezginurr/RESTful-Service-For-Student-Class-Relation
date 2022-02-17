package ezginur.onetomanyrestfulservice.service;

//import ezginur.onetomanyrestfulservice.exception.StudentNotFoundException;
import ezginur.onetomanyrestfulservice.model.Student;
import ezginur.onetomanyrestfulservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    /*
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudent(Long id){
        return studentRepository.findById(id).orElseThrow(() ->
                new StudentNotFoundException(id));
    }*/

    public List<Student> getStudents(){
        return StreamSupport
                .stream(studentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
