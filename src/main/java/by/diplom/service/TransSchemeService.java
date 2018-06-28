package by.diplom.service;

import by.diplom.model.TransScheme;

import java.util.List;
import java.util.Optional;

public interface TransSchemeService {
    List<TransScheme> getTransSchemeList();

    List<TransScheme> getTransSchemeByNumber(Integer numberTransScheme);

    void addTransScheme(TransScheme transScheme);

    void updateTransScheme(TransScheme transScheme);

    void deleteTransScheme(Integer numberTransScheme);
}
