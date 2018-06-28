package by.diplom.service;

import by.diplom.model.TermsDesc;

import java.util.List;

/**
 * Created by admin on 12.04.2018.
 */
public interface TermsDescService {
    List<TermsDesc> getTermsDesc();
    void addTermsDesc(TermsDesc termsDesc);

    void deleteTermsDesc(Integer idTermsDesc);

    void updateTermsDesc(TermsDesc termsDesc);
}
