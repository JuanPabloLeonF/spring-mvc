package co.com.jp.HolaMundoSpringData.controller;

import co.com.jp.HolaMundoSpringData.dao.IPersonDao;
import co.com.jp.HolaMundoSpringData.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ControllerStart {

    @Autowired
    private IPersonDao iPersonDao;

    @GetMapping("/")
    public String start(Model model) {

        Iterable<Person> listPerson = iPersonDao.findAll();

        model.addAttribute("listPerson", listPerson);
        return "index";
    }
    
    @GetMapping("/addPerson")
    public String addPerson(Person person, Model model) {
        
        
        Person personNew = iPersonDao.save(person);

        model.addAttribute("personNew", personNew);
        return "index";
    }
}
