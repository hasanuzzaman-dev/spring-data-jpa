package com.hasan.jpahibernate.controller;

import com.hasan.jpahibernate.model.Alien;
import com.hasan.jpahibernate.repo.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AlienRepo alienRepo;



    //ModelAttribute at Method level
    @ModelAttribute
    public void modelData(Model model){
        model.addAttribute("name", "Aliens");
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model model) {

        int result = i + j;
        model.addAttribute("result", result);

        return "result";
    }


    //PostMapping
    @PostMapping(value = "addAlien")
    public String addAlien(@ModelAttribute("alien") Alien alien){
        alienRepo.save(alien);
        return "result";
    }


    @GetMapping("getAliens")
    public String getAliens(Model model){
        model.addAttribute("result",alienRepo.findAll());

        return "showAliens";

    }

    @GetMapping("getAlien")
    public String getAlien(@RequestParam int aid, Model model){
        model.addAttribute("result",alienRepo.getOne(aid));

        return "showAliens";
    }
}
