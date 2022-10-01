package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello!!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("param") String name, Model model) {
        model.addAttribute("nana", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // body에 이 데이터를 직접 넣겠다
    public String helloString(@RequestParam("named") String name) {
        return "hello " + name; // "hello spring" -> 문자만 반환
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name); // 객체 : Json 반환
        return hello;
    }
}

class Hello {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}