package by.diplom.controller;

import by.diplom.model.Terminals;
import by.diplom.service.TerminalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 19.04.2018.
 */
@RestController
@RequestMapping("/api/terminals")
public class TerminalController {
    @Autowired
    private TerminalsService terminalsService;

    public TerminalController(TerminalsService terminalsService) {
        this.terminalsService = terminalsService;
    }

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Terminals> getTerminals() {
        return terminalsService.getTerminals();
    }

    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.OK)
    public void addTerminal(@RequestBody Terminals terminal) {
        terminalsService.addTerminal(terminal);
    }

    @DeleteMapping("/delete/{idTerminal}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTerminal(@PathVariable Integer idTerminal) {
        terminalsService.deleteTerminal(idTerminal);
    }

    @GetMapping("/searchName/{termName}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Terminals> searchTerminalsByTermName(@PathVariable String termName) {
        return terminalsService.searchTerminalsByTermName(termName);
    }

    @GetMapping("/searchId/{idTerminal}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Terminals> searchTerminalsByIdTerminal(@PathVariable Integer idTerminal) {
        return terminalsService.searchTerminalsById(idTerminal);
    }

    @PostMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTerminal(@RequestBody Terminals terminal) {
        terminalsService.updateTerminal(terminal);
    }

}
