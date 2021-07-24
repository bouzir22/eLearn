package com.example.demo.controller;

import com.example.demo.model.Video;
import com.example.demo.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ExposerController {
    @Autowired
    private VideoRepository videoRepository;
    @GetMapping("allvideos")
    public List<Video> getVideos()
    {return this.videoRepository.findAll();}

}
