package by.diplom.service;

import by.diplom.model.MerchTab;

import java.util.List;

/**
 * Created by admin on 12.04.2018.
 */
public interface MerchTabService {
    List<MerchTab> getMerchTabList();

    List<MerchTab> getMerchTab(String merchName);

    void addMerchTab(MerchTab merchTab);

    void deleteMerchTab(Integer idMerchTab);

    void updateMerchTab(MerchTab merchTab);


}
