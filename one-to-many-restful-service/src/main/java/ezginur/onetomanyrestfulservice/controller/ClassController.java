package ezginur.onetomanyrestfulservice.controller;

import ezginur.onetomanyrestfulservice.dto.ClassDto;
import ezginur.onetomanyrestfulservice.dto.StudentDto;
import ezginur.onetomanyrestfulservice.model.Student;
import ezginur.onetomanyrestfulservice.model.Class;
import ezginur.onetomanyrestfulservice.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/classes")
public class ClassController {
    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService){
        this.classService = classService;
    }

    @PostMapping(value = " --> add class")
    public ResponseEntity<ClassDto> addClass(@RequestBody final ClassDto classDto){
        Class schoolClass = classService.addClass(Class.from(classDto));
        return new ResponseEntity<>(ClassDto.from(schoolClass), HttpStatus.OK);
    }

    @GetMapping(value = " --> list classes")
    public ResponseEntity<List<ClassDto>> getClasses(){
        List<Class> classes = classService.getClasses();
        List<ClassDto> classesDto = classes.stream().map(ClassDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(classesDto, HttpStatus.OK);
    }

    @PostMapping(value = "{classId}/students/{student}/add --> add student to the class")
    public ResponseEntity<ClassDto> addStudentToClass(@PathVariable final Long classId,
                                                      @RequestBody final StudentDto studentDto){
        Class schoolClass = classService.addStudentToClass(classId, Student.from(studentDto));
        return new ResponseEntity<>(ClassDto.from(schoolClass), HttpStatus.OK);
    }


    @GetMapping(value = "{classId} --> get students from the class")
    public ResponseEntity<List<StudentDto>> getStudentsFromClass(@PathVariable final Long classId){
        Class schoolClass = classService.getClass(classId);
        List<Student> students = schoolClass.getStudents();
        List<StudentDto> studentsDto = students.stream().map(StudentDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(studentsDto, HttpStatus.OK);
    }


}
