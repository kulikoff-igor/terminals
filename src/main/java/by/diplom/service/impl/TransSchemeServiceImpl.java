package by.diplom.service.impl;

import by.diplom.model.TransScheme;
import by.diplom.repository.TransSchemeRepository;
import by.diplom.service.TransSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransSchemeServiceImpl implements TransSchemeService {
    @Autowired
    TransSchemeRepository transSchemeRepository;

    @Override
    public List<TransScheme> getTransSchemeList() {
        return transSchemeRepository.findAll();
    }

    @Override
    public List<TransScheme> getTransSchemeByNumber(Integer numberTransScheme) {
        return transSchemeRepository.findByNumberTransScheme(numberTransScheme);
    }

    @Override
    public void addTransScheme(TransScheme transScheme) {
        transSchemeRepository.saveAndFlush(transScheme);
    }

    @Override
    public void updateTransScheme(TransScheme transScheme) {
        transSchemeRepository.saveAndFlush(transScheme);
    }

    @Override
    public void deleteTransScheme(Integer numberTransScheme) {
        transSchemeRepository.deleteByNumberTransScheme(numberTransScheme);
    }
}
