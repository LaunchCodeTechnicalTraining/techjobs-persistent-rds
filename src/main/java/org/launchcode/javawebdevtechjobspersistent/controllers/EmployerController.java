package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.JobField;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("employers")
public class EmployerController {

    @Autowired
    private EmployerDao employerDao;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("employers", employerDao.findAll());
        model.addAttribute("title", "Employers");

        return "employers/index";
    }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute("title", "Add Employer");
        model.addAttribute(new Employer());
        //model.addAttribute("categories", jobDao.findAll());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Employer");
            return "employers/add";
        }

        //Category cat = categoryDao.findById(categoryId).orElse(new Category());
        //newCheese.setCategory(cat);
        employerDao.save(newEmployer);
        return "redirect:";
    }
}
