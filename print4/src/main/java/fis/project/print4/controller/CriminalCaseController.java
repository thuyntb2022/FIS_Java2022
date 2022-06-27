package fis.project.print4.controller;

import fis.project.print4.model.CriminalCase;
import fis.project.print4.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/print4")
public class CriminalCaseController {
    private final CriminalCaseService criminalCaseService;
    @Autowired
    public CriminalCaseController(CriminalCaseService criminalCaseService) {
        this.criminalCaseService = criminalCaseService;
    }

    @GetMapping("/criminal")
    public List<CriminalCase> getAllCriminalCase() {
        return criminalCaseService.findAll();
    }

}
