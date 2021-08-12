package ro.fasttrackit.finalproject.petclinicreservation.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("test")
public class TestUIController {
    @GetMapping
    String reservationPage( Model model ){
        model.addAttribute("message", "this is my project");
        model.addAttribute("users", List.of(
                new User("Cristi Tanase", "Bucharest"),
                new User("George Bucur", "Cluj Napoca"),
                new User("Alin Dragoi", "Arad")
        ));
        return "test";
    }
}

class User {
    private final String name;
    private final String address;

    public User( String name, String address ){
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }
}
