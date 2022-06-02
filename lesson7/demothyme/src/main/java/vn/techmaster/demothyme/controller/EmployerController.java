package vn.techmaster.demothyme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.techmaster.demothyme.model.Employer;
import vn.techmaster.demothyme.repository.EmployerRepository;

@Controller
public class EmployerController {
    @Autowired
    private EmployerRepository eRepository;

    @GetMapping("/employers")
    public String showEmployers(Model model) {
        model.addAttribute("employers", eRepository.getEmployers());
        return ("/employers");
    }

    @GetMapping("/addemployers")
    public String showEmployerForm(Model model) {
        model.addAttribute("newEmployer", new Employer());
        return "index";
    }

    @PostMapping("/addemployers")
    public String handleEmployerForm(@ModelAttribute Employer employer, BindingResult bindingResult,
            RedirectAttributes redirectAttrs, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(System.out::println);
            model.addAttribute("employers", eRepository.getEmployers());
            return "travel";
        }
        redirectAttrs.addFlashAttribute("successMessage", "Submit successfully");
        return "redirect:/";

    }
}
