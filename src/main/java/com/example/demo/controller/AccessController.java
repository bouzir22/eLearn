package com.example.demo.controller;
import com.example.demo.model.Tutor;
import com.example.demo.model.Video;
import com.example.demo.repository.TutorRepository;
import com.example.demo.repository.VideoRepository;
import com.example.demo.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class AccessController {
  Tutor tutor;
@Autowired
    AccessService accessService;
@Autowired
 private VideoRepository videoRepository;
    @GetMapping("/login")
    public String loginPage(){
        return"login"; }
@GetMapping("/update/{id}")
public String show(@PathVariable Long id,Model model){
    System.out.println(id);
   Video video= this.videoRepository.findById(id).get();
   model.addAttribute("video",video);
    return "edit";
}
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
this.videoRepository.deleteById(id);
        System.out.println(id);
        return "delete";
    }



        @Autowired
        private TutorRepository tutorRepository;
    @PostMapping("/authentificate")
    public String authentificate(@ModelAttribute Tutor tutor)
    {

     if(this.accessService.login(tutor.getUsername(),tutor.getPassword())){

         this.tutor=this.accessService.tutor;
         System.out.println(this.tutor);
         return "redirect:/dashboard";}
     return "login";
    }
@GetMapping("/register")
    public String registerPage(){
        return "register";
}

@PostMapping("/save")
        public String register (@Valid Tutor tutor , BindingResult bindingResult){
    if (bindingResult.hasErrors()) {
        return "register";
    }
else{
          this.accessService.save(tutor);    return "redirect:/dashboard";

    }


    }
    @GetMapping("/dashboard")
    public String dashboard(Model model){
       Tutor tutor =this.tutorRepository.findById(this.accessService.tutor.getId()).get();
        model.addAttribute("videos",tutor.getVideos());
        return "dashboard";
    }
@GetMapping("create")
    public String create()
{return"create";}


    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile file, @RequestParam MultipartFile img, Video video) throws IOException {
        System.out.println("uoloading******");
        System.out.println(this.accessService.tutor);
        video.setImage(video.getName());
        video.setTutor(this.accessService.tutor);
        this.accessService.upload(video);
//////////////////////////////////////////////////
        String path="C:\\Users\\AHMED\\Desktop\\Ahmed\\@web\\e-learn\\src\\assets\\videos\\";
        file.transferTo(new File(path+video.getName()+".mp4"));
        img.transferTo(new File(path+video.getName()+".jpg"));
        System.out.println("onUpload");
        System.out.println(this.accessService.tutor);
        return "redirect:/dashboard";
    }

}
