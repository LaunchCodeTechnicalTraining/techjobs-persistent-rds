package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.CoreCompetency;
import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.data.CoreCompetencyDao;
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
@RequestMapping("corecompetencies")
public class CoreCompetencyController {

    @Autowired
    private CoreCompetencyDao coreCompetencyDao;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("coreCompetencies", coreCompetencyDao.findAll());
        model.addAttribute("title", "Core Competencies");

        return "corecompetencies/index";
    }

    @GetMapping("add")
    public String displayAddCoreCompetencyForm(Model model) {
        model.addAttribute("title", "Add Core Competency");
        model.addAttribute("corecompetency", new CoreCompetency());
        //model.addAttribute("categories", jobDao.findAll());
        return "corecompetencies/add";
    }

    @PostMapping("add")
    public String processAddCoreCompetencyForm(@ModelAttribute @Valid CoreCompetency newCoreCompetency,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Core Competency");
            return "corecompetencies/add";
        }

        //Category cat = categoryDao.findById(categoryId).orElse(new Category());
        //newCheese.setCategory(cat);
        coreCompetencyDao.save(newCoreCompetency);
        return "redirect:";
    }
}
