package co.com.jp.ControlClientesSpring.Controller;

import co.com.jp.ControlClientesSpring.domain.Person;
import co.com.jp.ControlClientesSpring.services.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ControllerStart {

    @Autowired
    private IPersonService iPersonService;

    @GetMapping("/")
    public String start(Model model) {

        List<Person> listPerson = iPersonService.getListPerson();

        model.addAttribute("listPerson", listPerson);

        return "index";
    }


    
}
