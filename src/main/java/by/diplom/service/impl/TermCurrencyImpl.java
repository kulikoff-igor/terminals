package by.diplom.service.impl;

import by.diplom.model.TermCurrency;
import by.diplom.repository.TermCurrencyRepository;
import by.diplom.service.TermCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 18.04.2018.
 */
@Service
public class TermCurrencyImpl implements TermCurrencyService {
    @Autowired
    private TermCurrencyRepository termCurrencyRepository;

    @Override
    public List<TermCurrency> getTermCurrencyList() {
        return termCurrencyRepository.findAll();
    }

    @Override
    public void addTermCurrency(TermCurrency termCurrency) {
        termCurrencyRepository.saveAndFlush(termCurrency);
    }

    @Override
    public void deleteTermCurrency(Integer idTermCurrency) {
        termCurrencyRepository.deleteById(idTermCurrency);
    }

    @Override
    public void updateTermCurrency(TermCurrency termCurrency) {
        termCurrencyRepository.saveAndFlush(termCurrency);
    }

    @Override
    public TermCurrency searchTermCurrencyByTerminal(Integer idTerminal) {
        return termCurrencyRepository.findByTerminals(idTerminal);
    }
}
