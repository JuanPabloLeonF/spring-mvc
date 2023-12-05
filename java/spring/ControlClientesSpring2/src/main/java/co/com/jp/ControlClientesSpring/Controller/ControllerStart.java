package co.com.jp.ControlClientesSpring.Controller;

import co.com.jp.ControlClientesSpring.domain.Person;
import co.com.jp.ControlClientesSpring.services.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerStart {

    @Autowired
    private IPersonService iPersonService;

    @GetMapping({"/", ""})
    public String start(Model model) {

        List<Person> listPerson = iPersonService.getListPerson();
        model.addAttribute("listPerson", listPerson);
        return "index";
    }

    @GetMapping("/addPerson")
    public String addPersona(Person person) {
        return "modify";
    }

    @PostMapping("/saveForm")
    public String savePerson(@Validated Person person, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "modify";
        }
        iPersonService.savePerson(person);
        return "redirect:/";
    }

    @GetMapping("/modifyPerson/{idPerson}")
    public String modifyPersona(Person person, Model model) {
        person = iPersonService.findByIdPerson(person);
        model.addAttribute("person", person);
        return "modify";
    }

    @GetMapping("/deletePerson")
    public String deletePerson(Person person) {
        iPersonService.deletePerson(person);
        return "redirect:/";
    }
}
