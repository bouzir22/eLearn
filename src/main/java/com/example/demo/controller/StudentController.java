package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.Subscription;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubsRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private SubsRepository subsRepository;

    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/all")
    public List<Student>getAll()
    {return  this.studentService.getAll();}
    @GetMapping("/{id}")
    public Student getCurrent(@PathVariable Long id)
    {return  this.studentRepository.findById(id).get();}
    @GetMapping("/subs/{id}")
    public List<Subscription> getSubs(@PathVariable Long id)
    { return  this.subsRepository.findByStudentId(id);}
    @GetMapping("findByUsername/{username}")
    public Student findByUsername(@PathVariable String username)
    {return this.studentRepository.findByUsername(username);
    }
    @PostMapping("/register")
public Student register(@RequestBody Student student)
    {return this.studentRepository.save(student);}
}
