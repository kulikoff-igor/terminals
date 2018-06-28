package by.diplom.service;

import by.diplom.model.TermCurrency;

import java.util.List;

public interface TermCurrencyService {
    List<TermCurrency> getTermCurrencyList();

    void addTermCurrency(TermCurrency termCurrency);

    void deleteTermCurrency(Integer idTermCurrency);

    void updateTermCurrency(TermCurrency termCurrency);

    TermCurrency searchTermCurrencyByTerminal(Integer idTerminal);

}
