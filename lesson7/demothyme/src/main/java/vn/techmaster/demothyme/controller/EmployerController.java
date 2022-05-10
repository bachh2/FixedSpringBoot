package vn.techmaster.demothyme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.demothyme.model.Employer;
import vn.techmaster.demothyme.repository.EmployerRepository;

@Controller
public class EmployerController {
   @Autowired
   private EmployerRepository eRepository;

   @GetMapping("/employers")
   public String showEmployers() {
       return ("/employers");
   }

   @GetMapping("/addemployers")
   public String showEmployerForm(Model model) {
       model.addAttribute("newEmployer", new Employer());
       return "index";
   }

   @PostMapping("/addemployers")
   public String handleEmployerForm(@ModelAttribute Employer employer, Model model) {
      
       return "redirect:/";
   }
}
