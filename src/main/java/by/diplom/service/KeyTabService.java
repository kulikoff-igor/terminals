package by.diplom.service;

import by.diplom.model.KeyTab;

import java.util.List;

public interface KeyTabService {


    KeyTab getKeyAuthorizationByIdTerminal(Integer idTerminal);

    void addKeyAuthorization(KeyTab keyTab);

    void deleteKeyAuthorization(Integer idKeyAuthorization);

    void updateKeyAuthorization(KeyTab keyTab);

}
