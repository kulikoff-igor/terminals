package by.diplom.repository;

import by.diplom.model.KeyTab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KeyTabRepository extends JpaRepository<KeyTab, Integer> {
    @Query(value = "SELECT key_tab.* FROM key_tab WHERE key_tab.id_terminals = :idTerminal", nativeQuery = true)
    KeyTab findByIdTerminal(@Param("idTerminal") Integer idTerminal);
}
