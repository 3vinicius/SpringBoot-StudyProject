package vinicius.mywebapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vinicius.mywebapi.model.User;
import vinicius.mywebapi.repository.UserRepository;


@Component
public class StartApp implements CommandLineRunner{

    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {


    }
}
