package com.tpe.controller;


import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller//requestler bu classta karşılanacak ve ilgili metodlarla maplenecek
@RequestMapping("/students")//http:localhost:8080/SpringMvc/students/....
//class:tüm metodlar için geçerli olur
//method:sadece ilgili metodu requestle mapler
public class StudentController {

    @Autowired
    private StudentService service;

    //http:localhost:8080/SpringMvc/students/hi + GET
    @GetMapping("/hi")
    public ModelAndView sayHi() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Hi,");
        mav.addObject("messagebody", "I'm a Student Management System");
        mav.setViewName("hi");
        return mav;
    }

    //view resolver : /WEB-INF/views/hi.jsp dosyasını bulur ve mav içindeki modalı
    //dosyaya bind eder ve clienta gönderir.

    //1- Tüm öğrencileri listeleme
    // http://localhost:8080/SpringMvc/students/ + GET

    @GetMapping
    public ModelAndView getStudents() {
        List<Student> allStudents = service.listAllStudents();
        ModelAndView mav = new ModelAndView();
        mav.addObject("studentList", allStudents);
        mav.setViewName("students");
        return mav;
    }


}
