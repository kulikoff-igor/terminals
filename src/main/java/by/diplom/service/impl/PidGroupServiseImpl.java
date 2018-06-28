package by.diplom.service.impl;

import by.diplom.model.PidGroup;
import by.diplom.repository.PidGroupRepository;
import by.diplom.service.PidGroupServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PidGroupServiseImpl implements PidGroupServise {
    @Autowired
    private PidGroupRepository pidGroupRepository;
    @Override
    public List<PidGroup> getPidGroupsList() {
        return pidGroupRepository.findAll();
    }

    @Override
    public void addPidGroup(PidGroup pidGroup) {
pidGroupRepository.saveAndFlush(pidGroup);
    }

    @Override
    public void updatePidGroup(PidGroup pidGroup) {
        pidGroupRepository.saveAndFlush(pidGroup);
    }

    @Override
    public void deletePidGroup(Integer numberPidGroup) {
        pidGroupRepository.deleteByNumberPidGroup(numberPidGroup);
    }
}
