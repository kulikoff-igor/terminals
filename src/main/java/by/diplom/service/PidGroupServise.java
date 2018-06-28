package by.diplom.service;

import by.diplom.model.PidGroup;

import java.util.List;

public interface PidGroupServise {
    List<PidGroup> getPidGroupsList();

    void addPidGroup(PidGroup pidGroup);

    void updatePidGroup(PidGroup pidGroup);

    void deletePidGroup(Integer numberPidGroup);
}

