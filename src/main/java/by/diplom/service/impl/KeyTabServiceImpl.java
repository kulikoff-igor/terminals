package by.diplom.service.impl;

import by.diplom.model.KeyTab;
import by.diplom.repository.KeyTabRepository;
import by.diplom.service.KeyTabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyTabServiceImpl implements KeyTabService {
    @Autowired
    private KeyTabRepository keyTabRepository;


    @Override
    public KeyTab getKeyAuthorizationByIdTerminal(Integer idTerminal) {
        return keyTabRepository.findByIdTerminal(idTerminal);
    }

    @Override
    public void addKeyAuthorization(KeyTab keyTab) {
        keyTabRepository.saveAndFlush(keyTab);
    }

    @Override
    public void deleteKeyAuthorization(Integer idKeyAuthorization) {
        keyTabRepository.deleteById(idKeyAuthorization);
    }

    @Override
    public void updateKeyAuthorization(KeyTab keyTab) {
        keyTabRepository.saveAndFlush(keyTab);
    }


}
