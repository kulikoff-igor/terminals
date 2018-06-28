package by.diplom.service;

import by.diplom.model.TransTypeDesc;

import java.util.List;

public interface TransTypeDescService {
    List<TransTypeDesc> getTransTypeDescList();
    void addTransTypeDesc(TransTypeDesc transTypeDesc);

    void updateTransTypeDesc(TransTypeDesc transTypeDesc);

    void deleteTransTypeDesc(Integer idTransTypeDesc);
}
