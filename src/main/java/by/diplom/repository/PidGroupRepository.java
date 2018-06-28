package by.diplom.repository;

import by.diplom.model.PidGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PidGroupRepository extends JpaRepository<PidGroup, Integer> {
    void deleteByNumberPidGroup(Integer numberPidGroup);
}
