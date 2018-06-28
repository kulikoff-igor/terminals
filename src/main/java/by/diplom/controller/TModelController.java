package by.diplom.controller;

import by.diplom.model.TModel;
import by.diplom.service.TModelService;
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
@RequestMapping("/api/terminals/tmodel")
public class TModelController {
    @Autowired
    TModelService tModelService;

    public TModelController(TModelService tModelService) {
        this.tModelService = tModelService;
    }

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TModel> getTerminals() {
        return tModelService.getModel();
    }

}
