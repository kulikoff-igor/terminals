package by.diplom.controller;

import by.diplom.model.MerchTab;
import by.diplom.service.MerchTabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 20.04.2018.
 */
@RestController
@RequestMapping("/api/merchTab")
public class MerchTabController {
    @Autowired
    private MerchTabService merchTabService;

    public MerchTabController(MerchTabService merchTabService) {
        this.merchTabService = merchTabService;
    }

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<MerchTab> getMerchTabList() {
        return merchTabService.getMerchTabList();
    }

    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.OK)
    public void addMerchTab(@RequestBody MerchTab merchTab) {
        merchTabService.addMerchTab(merchTab);
    }

    @GetMapping("/search/{merchName}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<MerchTab> getMerchTab(@PathVariable String merchName) {
        return merchTabService.getMerchTab(merchName);
    }

    @PostMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateMerchTab(@RequestBody MerchTab merchTab) {
        merchTabService.updateMerchTab(merchTab);
    }

    @DeleteMapping("/delete/{idLegalEntity}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteLegalEntity(@PathVariable Integer idLegalEntity) {
        merchTabService.deleteMerchTab(idLegalEntity);
    }
}
