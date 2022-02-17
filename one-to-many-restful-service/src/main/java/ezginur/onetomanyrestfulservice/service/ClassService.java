package ezginur.onetomanyrestfulservice.service;

import ezginur.onetomanyrestfulservice.exception.ClassNotFoundException;
import ezginur.onetomanyrestfulservice.model.Class;
import ezginur.onetomanyrestfulservice.model.Student;
import ezginur.onetomanyrestfulservice.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    @Autowired
    public ClassService(ClassRepository classRepository){
        this.classRepository = classRepository;
    }

    public Class addClass(Class schoolClass){
        return classRepository.save(schoolClass);
    }

    public List<Class> getClasses(){
        return StreamSupport
                .stream(classRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Class getClass(Long id){
        return classRepository.findById(id).orElseThrow(() ->
                new ClassNotFoundException(id));
    }

    @Transactional
    public Class addStudentToClass(Long classId, Student student){
        Class schoolClass = getClass(classId);
        schoolClass.addStudent(student);
        return schoolClass;
    }
}
