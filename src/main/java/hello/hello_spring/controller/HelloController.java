package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    // required = true : 값이 없으면 400에러 반환 / required = false : 값이 없으면 null 처리
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    // @ResponseBody : html body 부분에 해당 data를 넣겠다
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
