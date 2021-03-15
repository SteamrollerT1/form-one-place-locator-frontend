package com.dsw.formoneplaceallocator.controllers;

import com.dsw.formoneplaceallocator.dtos.StudentDTO;
import com.dsw.formoneplaceallocator.services.iface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/test")
    @ResponseBody
    String test() {
        return "Form one registration system GUI up!!!";
    }


    @GetMapping("/register")
    String register(Model model) {
        model.addAttribute("dto", new StudentDTO());
        return "student/registration";
    }


    @PostMapping("/register")
    String register(StudentDTO dto) {
        studentService.register(dto);
        return "student/profile";
    }
}
