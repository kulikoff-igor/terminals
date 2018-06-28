package by.diplom.service.impl;

import by.diplom.model.MerchTab;
import by.diplom.model.Terminals;
import by.diplom.model.TermsDesc;
import by.diplom.repository.TerminalsRepository;
import by.diplom.service.TerminalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 11.04.2018.
 */
@Service
public class TerminalsServiceImpl implements TerminalsService {
    @Autowired
    private TerminalsRepository terminalsRepository;

    @Override
    public List<Terminals> getTerminals() {
        return terminalsRepository.findAll();
    }

    @Override
    public List<Terminals> searchTerminalsByTermName(String termName) {
        return terminalsRepository.findByTermNameContaining(termName);
    }

    @Override
    public List<Terminals> searchTerminalsById(Integer idTerminals) {
        return terminalsRepository.findByIdTerminalsLike(idTerminals);
    }

    @Override
    public void addTerminal(Terminals terminals) {
        terminalsRepository.saveAndFlush(terminals);

    }

    @Override
    public void deleteTerminal(Integer idTerminal) {
        terminalsRepository.deleteById(idTerminal);

    }

    @Override
    public void updateTerminal(Terminals terminals) {
        terminalsRepository.saveAndFlush(terminals);

    }
}
