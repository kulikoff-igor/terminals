package by.diplom.controller;

import by.diplom.model.TransTypeDesc;
import by.diplom.service.TransTypeDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 10.05.2018.
 */
@RestController
@RequestMapping("/api/type-operation/")
public class TransTypeDescController {
    @Autowired
    private TransTypeDescService transTypeDescService;

    public TransTypeDescController(TransTypeDescService transTypeDescService) {
        this.transTypeDescService = transTypeDescService;
    }

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TransTypeDesc> getListTypeOperation() {
        return transTypeDescService.getTransTypeDescList();
    }

}
