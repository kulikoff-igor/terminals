package by.diplom.service.impl;

import by.diplom.model.TermsDesc;
import by.diplom.repository.TermsDescRepository;
import by.diplom.service.TermsDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 12.04.2018.
 */
@Service
public class TermsDescServiceImpl implements TermsDescService {
    @Autowired
    private TermsDescRepository termsDescRepository;

    @Override
    public List<TermsDesc> getTermsDesc() {
        return termsDescRepository.findAll();
    }

    @Override
    public void addTermsDesc(TermsDesc termsDesc) {
        termsDescRepository.saveAndFlush(termsDesc);
    }

    @Override
    public void deleteTermsDesc(Integer idTermsDesc) {
        termsDescRepository.deleteById(idTermsDesc);
    }

    @Override
    public void updateTermsDesc(TermsDesc termsDesc) {
        termsDescRepository.saveAndFlush(termsDesc);
    }

}
