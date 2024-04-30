package com.tpe.service;

import java.util.List;


import com.tpe.domain.Student;
import com.tpe.exception.StudentNotFoundException;
import com.tpe.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//@Component
@Service//@Component anatasyonunun (gelişmiş)özel halidir.
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository repository;

    //1-a
    @Override
    public List<Student> listAllStudents() {

        return repository.findAll();
    }

    //2-b
    @Override
    public void addOrUpdateStudent(Student student) {
        repository.saveOrUpdate(student);
    }

    @Override
    public Student findStudentById(Long id) {

        Student foundStudent = repository.findById(id).
                orElseThrow(() -> new StudentNotFoundException("Student not found by ID : " + id));
        //findById metodunun geriye döndürdüğü optional içinde
        //student varsa foundstudent değişkenine atar.
        //Optional objesi boşsa orElseThrow custom exception fırlatır.
        return foundStudent;
    }

    @Override
    public void deleteStudent(Long id) {
        Student foundStudent = findStudentById(id);
        repository.delete(foundStudent);
    }





}
