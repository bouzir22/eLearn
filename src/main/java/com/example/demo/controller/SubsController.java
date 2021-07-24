package com.example.demo.controller;

import com.example.demo.service.SubsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class SubsController

{
    @Autowired
    private SubsService subsService;
    @GetMapping("subscribe/{ids}/{idt}")
    public void subscribe(@PathVariable Long ids,@PathVariable Long idt)
    {this.subsService.subscribe(ids,idt);}

    @GetMapping ("delete/{idt}/{ids}")
    void unSubscribe(@PathVariable Long idt,@PathVariable Long ids)
    { this.subsService.usnSubscribe(idt,ids);}
}
