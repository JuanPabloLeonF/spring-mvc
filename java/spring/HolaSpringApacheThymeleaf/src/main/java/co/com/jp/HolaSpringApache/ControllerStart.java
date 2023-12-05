package co.com.jp.HolaSpringApache;

import co.com.jp.domain.Person;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
@Slf4j
public class ControllerStart {
    
    @GetMapping("/")
    public String start(Model model) {
        var hello = "Mensaje mundo con thymeleaf";
        log.info("ejecutando el controlador");
        log.debug("mas detalles del controlador");
        
        Person person = new Person();
        person.setName("Juan");
        person.setLastName("leon");
        person.setEmail("hj@gmail.com");
        person.setPhone("3241");
        
        Person person2 = new Person();
        person2.setName("Juan camilo");
        person2.setLastName("leon fonseca");
        person2.setEmail("hj@gmail.com");
        person2.setPhone("3241 ghja");
        
        List<Person> listPerson = new ArrayList<>();
        
        listPerson.add(person);
        listPerson.add(person2);
        
        //model.addAttribute("person", person);
        model.addAttribute("listPerson", listPerson);
        return "index";
    }
}
