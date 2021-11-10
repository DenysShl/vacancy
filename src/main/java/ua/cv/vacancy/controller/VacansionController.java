package ua.cv.vacancy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.cv.vacancy.model.Vacansion;
import ua.cv.vacancy.service.VacansionService;

import java.util.List;

@Controller
public class VacansionController {

    private final VacansionService service;

    @Autowired
    public VacansionController(VacansionService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showIndex(Model model) {
        List<Vacansion> vacansionList = service.findAllVacansion();
        model.addAttribute("vacansionList", vacansionList);
        return "index";
    }

    @GetMapping("/vacan")
    public String showVacan(Model model) {
        List<Vacansion> vacansionList = service.findAllVacansion();
        model.addAttribute("result", vacansionList);
        return "vacan";
    }

    @GetMapping("/search")
    public String searchByKeyword(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Vacansion> vacansions = service.findByKeyword(keyword);
        model.addAttribute("vacansionList", vacansions);
        return "search";
    }

    @GetMapping("/searchVacancy")
    public String searchByKeywordVacan(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Vacansion> vacansions = service.findByKeyword(keyword);
        model.addAttribute("result", vacansions);
        return "vacan";
    }

    @GetMapping("/update/{id}")
    public String updateVacansionForm(@PathVariable(value = "id", required = false) Long id, Model model) {
        Vacansion editVacansion = service.findById(id);
        model.addAttribute("editVacansion", editVacansion);
        return "update";
    }

    @PostMapping("/update")
    public String updateVacancy(@ModelAttribute("vacansionForId") Vacansion vacansion) {
        service.updateVacansion(vacansion);
        return "redirect:/vacan";
    }

    @GetMapping("/create")
    public String addVacansion() {
        return "create";
    }

    @PostMapping("new")
    public String createVacansion(@ModelAttribute("vacancy") Vacansion vacansion) {
        service.createNewVacansion(vacansion);
        return "redirect:/vacan";
    }

    @GetMapping("/delete/{id}")
    public String deleteVacansionById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "redirect:/vacan";
    }
}