package com.example.demo.controller;

import com.example.demo.model.Video;
import com.example.demo.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin("*")
@RequestMapping("video")
public class VideoController {
    @Autowired
    VideoRepository videoRepository;
  @GetMapping("all")
    public List<Video>getAll()
    {return this.videoRepository.findAll();}
    @GetMapping("byid/{id}")
    Video getById(@ PathVariable Long
                  id)
    {return  this.videoRepository.findById(id).get();}
    @GetMapping("playlist/{name}")
    List<Video> findByPlaylist(@PathVariable String name)
    {return  this.videoRepository.findByPlaylist(name);}
}
