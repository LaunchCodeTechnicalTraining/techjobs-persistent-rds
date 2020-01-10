package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.CoreCompetency;
import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.data.CoreCompetencyDao;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerDao;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private JobDao jobDao;

    @Autowired
    private EmployerDao employerDao;

    @Autowired
    private CoreCompetencyDao coreCompetencyDao;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("jobs", jobDao.findAll());
        model.addAttribute("title", "My Jobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerDao.findAll());
        //model.addAttribute("coreCompetencies", coreCompetencyDao.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }

        Employer employer = employerDao.findById(employerId).orElse(new Employer());
        newJob.setEmployer(employer);
        jobDao.save(newJob);
        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        Job job = jobDao.findById(jobId).orElse(new Job());
        model.addAttribute("job", job);

        return "view";
    }


}
