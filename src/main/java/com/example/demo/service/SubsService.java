package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.Subscription;
import com.example.demo.model.Tutor;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubsRepository;
import com.example.demo.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubsService {
    @Autowired
    TutorRepository tutorRepository;
    @Autowired
    SubsRepository subsRepository;
    @Autowired
    private StudentRepository studentRepository;

    public void subscribe(Long ids,Long idt){
        Tutor tutor=this.tutorRepository.findById(idt).get();
        Student student=this.studentRepository.findById(ids).get();
        Subscription subscription=new Subscription();
        subscription.setTutor(tutor);
        subscription.setStudent(student);
        this.subsRepository.save(subscription);


    }

    public void usnSubscribe(Long idt,Long ids) {
        System.out.println();
        Subscription sub =this.subsRepository.findByTutorIdAndStudentId(idt,ids);
        this.subsRepository.delete(sub);

    }
}
