package com.firstspringapp.service;

import com.firstspringapp.model.Greeting;
import com.firstspringapp.model.User;
import com.firstspringapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template="Hello,%s!";
    private final AtomicLong counter=new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message=String.format(template,(user.toString().isEmpty())?"Hello world" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
    }

    @Override
    public Optional<Greeting> getGreetingById(long id) {
        return greetingRepository.findById(id);
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting updateGreeting(long id , String message) {
        Greeting greeting = greetingRepository.findById(id).orElse(null);
        greeting.setMessage(message);
        return greetingRepository.save(greeting);
    }

    @Override
    public void deleteGreeting(long id) {
        greetingRepository.deleteById(id);
    }
}
