package by.diplom.service.impl;

import by.diplom.model.TModel;
import by.diplom.repository.TModelRepository;
import by.diplom.service.TModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TModelServiceImpl implements TModelService {
    @Autowired
    private TModelRepository tModelRepository;

    @Override
    public List<TModel> getModel() {
        return tModelRepository.findAll();
    }

    @Override
    public void addTmodel(TModel tModel) {
        tModelRepository.saveAndFlush(tModel);
    }

    @Override
    public void updateTModel(TModel tModel) {
        tModelRepository.saveAndFlush(tModel);
    }

    @Override
    public void deleteTModel(Integer idTModel) {
        tModelRepository.deleteById(idTModel);
    }
}
