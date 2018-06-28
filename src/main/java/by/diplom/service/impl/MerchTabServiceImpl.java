package by.diplom.service.impl;

import by.diplom.model.MerchTab;
import by.diplom.repository.MerchTabRepository;
import by.diplom.service.MerchTabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 12.04.2018.
 */
@Service
public class MerchTabServiceImpl implements MerchTabService {
    @Autowired
    private MerchTabRepository merchTabRepository;

    @Override
    public List<MerchTab> getMerchTabList() {
        return merchTabRepository.findAll();
    }

    @Override
    public List<MerchTab> getMerchTab(String merchName) {
        return merchTabRepository.findByMerchNameContaining(merchName);
    }

    @Override
    public void addMerchTab(MerchTab merchTab) {
        merchTabRepository.saveAndFlush(merchTab);
    }

    @Override
    public void deleteMerchTab(Integer idMerchTab) {
        merchTabRepository.deleteById(idMerchTab);
    }

    @Override
    public void updateMerchTab(MerchTab merchTab) {
        merchTabRepository.saveAndFlush(merchTab);
    }

}
