package com.example.demo.service;

import com.example.demo.model.Tutor;
import com.example.demo.model.Video;
import com.example.demo.repository.TutorRepository;
import com.example.demo.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class AccessService {
    @Autowired
    private TutorRepository tutorRepository;
    public Tutor tutor;

    public boolean login(String username , String password ){
        Tutor tutor =this.tutorRepository.findByUsername(username);
        System.out.println(this.tutorRepository.findByUsername(username));
        if (tutor.getPassword().equals(password)){
            this.tutor=tutor;
            return true;

        }

        return false;

    }

    public void save(Tutor tutor){ this.tutor=this.tutorRepository.save(tutor);


    }

    @Autowired
    VideoRepository videoRepository;
public  void upload(Video video){

        this.videoRepository.save(video);
}


}
