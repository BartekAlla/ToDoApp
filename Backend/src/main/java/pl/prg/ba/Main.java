package pl.prg.ba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.prg.ba.Enums.User.Gender;
import pl.prg.ba.Model.User;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        new ToDoApp().run();
    }
}