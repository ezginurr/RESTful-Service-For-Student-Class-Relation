package ezginur.onetomanyrestfulservice.controller;

import ezginur.onetomanyrestfulservice.model.Student;
import ezginur.onetomanyrestfulservice.dto.StudentDto;
import ezginur.onetomanyrestfulservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    /*
    @PostMapping(value = " --> add student")
    public ResponseEntity<StudentDto> addStudent(@RequestBody final StudentDto studentDto){
        Student student = studentService.addStudent(Student.from(studentDto));
        return new ResponseEntity<>(StudentDto.from(student), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudents(){
        List<Student> students = studentService.getStudents();
        List<StudentDto> studentsDto = students.stream().map(StudentDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(studentsDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable final Long id) {
        Student student = studentService.getStudent(id);
        return new ResponseEntity<>(StudentDto.from(student), HttpStatus.OK);
    }
    */

}
