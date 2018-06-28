package by.diplom.controller;

import by.diplom.model.TermsDesc;
import by.diplom.service.TermsDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by admin on 21.04.2018.
 */
@RestController
@RequestMapping("/api/terminals/description")
public class TermsDescController {
    @Autowired
    private TermsDescService termsDescService;

    public TermsDescController(TermsDescService termsDescService) {
        this.termsDescService=termsDescService;
    }
    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TermsDesc> getTerminals() {
        return termsDescService.getTermsDesc();
    }
}
