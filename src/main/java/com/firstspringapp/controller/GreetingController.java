package com.firstspringapp.controller;

import com.firstspringapp.model.Greeting;
import com.firstspringapp.model.User;
import com.firstspringapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingsController {

    @Autowired
    private IGreetingService greetingService;

    @RequestMapping(value = {"","/","/home"})
    public Greeting greeting(@RequestParam(value = "name" ,defaultValue = "world") String name){
        User user=new User();
        user.setFirstname(name);
        return greetingService.addGreeting(user);
    }

//    @GetMapping("/getById/{id}")
//    public Optional<Greeting> getGreetingById(@PathVariable long id){
//        return greetingService.getGreetingById(id);
//    }
//    @GetMapping("/getAllGreetings")
//    public List<Greeting> getGreetings(){
//        return greetingService.getAllGreetings();
//    }
//    @PostMapping("/post")
//    public Greeting postGreeting(@RequestParam String firstName,String lastName){
//        User user=new User();
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        return greetingService.addGreeting(user);
//    }
//    @PutMapping("/updateGreeting/{id}")
//    public Greeting updateGreeting(@PathVariable long id,@RequestParam String message){
//        return greetingService.updateGreeting(id,message);
//    }
//    @DeleteMapping("/deleteGreeting/{id}")
//    public void deleteGreeting(@PathVariable long id){
//         greetingService.deleteGreeting(id);
//    }
}
