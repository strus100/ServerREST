package matuszewski.pracownia.controller.web;

import matuszewski.pracownia.model.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("cityModel",new City());
        return "index";
}
}
