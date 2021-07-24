package com.example.demo.controller;

import com.example.demo.model.Tutor;
import com.example.demo.model.Video;
import com.example.demo.repository.TutorRepository;
import com.example.demo.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutor")
@CrossOrigin("*")

public class TutorController {

    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private VideoRepository videoRepository;
    @GetMapping("all")
    public List<Tutor> getAll()
    {return  this.tutorRepository.findAll();}
    @GetMapping("byvideo/{id}")
    Tutor findByVideoID(@PathVariable Long id)
    {
        Video v =this.videoRepository.findById(id).get();

       return  null;}

       @GetMapping("byId/{id}")
    Tutor findById(@PathVariable Long id)
       {return this.tutorRepository.findById(id).get();}

}
