package com.firstspringapp.service;






import com.firstspringapp.model.Greeting;
import com.firstspringapp.model.User;

import java.util.List;
import java.util.Optional;


public interface IGreetingService {
     Greeting addGreeting(User user);
     Optional<Greeting> getGreetingById(long id);

     List<Greeting> getAllGreetings();

     Greeting updateGreeting(long id, String message);

     void deleteGreeting(long id);
}

