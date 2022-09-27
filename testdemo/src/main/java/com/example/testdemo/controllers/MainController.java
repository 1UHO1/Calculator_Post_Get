package com.example.testdemo.controllers;


import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.dom.DOMCryptoContext;

@Controller
public class MainController {

    private DOMCryptoContext document;

    @GetMapping("/")
    public String greeting(Model model) {
        Integer a = 0;
        a = 1;
        model.addAttribute("title", a);
        return "home";
    }

    @GetMapping("/calc")
    public String Calc(Model model) {
        model.addAttribute("title", 0);

        return "home";}


    @GetMapping("/res")
    public String GetResult(
            @RequestParam(
                    value = "variable1",
                    required = false,
                    defaultValue = "2") double a,
            @RequestParam(
                    value = "variable3",
                    required = false,
                    defaultValue = "4") double b,
            @RequestParam (
                    value = "z1",
                    required = false,
                    defaultValue = "0") String z1,


            Model model) {
        double ds = switch (z1){
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 1;
        };





        model.addAttribute("answer",ds);
        return "result";
   }

    @PostMapping("/res")
    public String PostResult(
           @RequestParam(
        value = "variable",
                    required = false,
                    defaultValue = "0") double a,
            @RequestParam(
                    value = "variable2",
                    required = false,
                    defaultValue = "0") double b,
            @RequestParam (
                    value = "z",
                    required = false,
                    defaultValue = "0") String z,


            Model model) {
        double d = switch (z) {

            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };

        model.addAttribute("answer",d);
        return "result";
    }


}


