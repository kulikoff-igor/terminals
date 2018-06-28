package by.diplom.service;

import by.diplom.model.MerchTab;
import by.diplom.model.Terminals;
import by.diplom.model.TermsDesc;

import java.util.List;

/**
 * Created by admin on 11.04.2018.
 */
public interface TerminalsService {
    List<Terminals> getTerminals();

    List<Terminals> searchTerminalsByTermName(String termName);

    List<Terminals> searchTerminalsById(Integer idTerminals);

    void addTerminal(Terminals terminals);

    void deleteTerminal(Integer idTerminal);

    void updateTerminal(Terminals terminals);
}
