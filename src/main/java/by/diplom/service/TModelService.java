package by.diplom.service;

import by.diplom.model.TModel;

import java.util.List;

public interface TModelService {
    List<TModel> getModel();
    void addTmodel(TModel tModel);
    void updateTModel(TModel tModel);
    void  deleteTModel(Integer idTModel);
}
