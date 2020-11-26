package com.firstspringapp.controller;

import com.firstspringapp.model.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping(value = "/helloc")
public class HelloWorldController {
    @RequestMapping(value = {"","/","/home"}, method = RequestMethod.GET)
    public String sayHello(){
        return "Hello world";
    }



@RequestMapping(value = {"/query"}, method = RequestMethod.GET)
public String sayHello(@RequestParam(value = "fname") String fname, @RequestParam(value = "lname") String lname){
    return "hello "+fname+" "+lname;
}
@GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name){
        return "hello "+name;
}

    @PostMapping("/post")
    public String sayHello(@RequestBody User user) {
        return "Hello "+ user.getFirstname() + " " + user.getLastname() + "!";

    }

    @PutMapping("/put/{firstName}")
    public String sayHelloPut(@PathVariable String firstName, @RequestParam(value = "LastName") String lastName) {
        return "Hello " + firstName + " " + lastName + "!";

    }


}
