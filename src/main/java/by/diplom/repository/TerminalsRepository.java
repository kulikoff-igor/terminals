package by.diplom.repository;

import by.diplom.model.Terminals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * Created by admin on 11.04.2018.
 */
public interface TerminalsRepository extends JpaRepository<Terminals, Integer> {
    @Nullable
    List<Terminals> findByTermNameContaining(String termName);
    @Nullable
    List<Terminals> findByIdTerminalsLike(Integer idTerminals);

}
