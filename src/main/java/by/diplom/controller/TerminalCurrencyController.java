package by.diplom.controller;

import by.diplom.model.TermCurrency;
import by.diplom.service.TermCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 08.05.2018.
 */
@RestController
@RequestMapping("/api/currency/")
public class TerminalCurrencyController {

    @Autowired
    private TermCurrencyService termCurrencyService;

    public TerminalCurrencyController(TermCurrencyService termCurrencyService) {
        this.termCurrencyService = termCurrencyService;
    }

    @GetMapping("/search/{idTerminal}")
    @ResponseStatus(value = HttpStatus.OK)
    public TermCurrency searchTermCurrencyByTerminal(@PathVariable Integer idTerminal) {
        return termCurrencyService.searchTermCurrencyByTerminal(idTerminal);
    }
}
