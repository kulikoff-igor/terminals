package by.diplom.service.impl;

import by.diplom.model.TransTypeDesc;
import by.diplom.repository.TransTypeDescRepository;
import by.diplom.service.TransTypeDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransTypeDescServiceImpl implements TransTypeDescService {
    @Autowired
    private TransTypeDescRepository transTypeDescRepository;

    @Override
    public List<TransTypeDesc> getTransTypeDescList() {
        return transTypeDescRepository.findAll();
    }

    @Override
    public void addTransTypeDesc(TransTypeDesc transTypeDesc) {
        transTypeDescRepository.saveAndFlush(transTypeDesc);
    }

    @Override
    public void updateTransTypeDesc(TransTypeDesc transTypeDesc) {
        transTypeDescRepository.saveAndFlush(transTypeDesc);
    }

    @Override
    public void deleteTransTypeDesc(Integer idTransTypeDesc) {
        transTypeDescRepository.deleteById(idTransTypeDesc);
    }
}
