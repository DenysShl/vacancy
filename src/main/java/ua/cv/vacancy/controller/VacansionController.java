package ua.cv.vacancy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping(value = {"/", "/index"})
    public String viewHomePage(Model model) {
        return findPaginated(1, "posada", "asc", model);
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
        return "update_vacansion";
    }

    @PostMapping("/update")
    public String updateVacancy(@ModelAttribute("vacansionForId") Vacansion vacansion) {
        service.updateVacansion(vacansion);
        return "redirect:/vacan";
    }

    @GetMapping("/create")
    public String addVacansion() {
        return "create_vacansion";
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

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Vacansion> page = service.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Vacansion> listVacansion = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("vacansionList", listVacansion);
        return "index";
    }
}