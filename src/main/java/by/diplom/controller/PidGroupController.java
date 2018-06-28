package by.diplom.controller;

import by.diplom.model.PidGroup;
import by.diplom.service.PidGroupServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by admin on 10.05.2018.
 */
@RestController
@RequestMapping("/api/pid-group/")
public class PidGroupController {
    @Autowired
    PidGroupServise pidGroupServise;

    public PidGroupController(PidGroupServise pidGroupServise) {
        this.pidGroupServise = pidGroupServise;
    }

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<PidGroup> getListPidGroup() {
        return pidGroupServise.getPidGroupsList();
    }
}
