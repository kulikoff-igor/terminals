package by.diplom.repository;

import by.diplom.model.TermCurrency;
import by.diplom.model.Terminals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;

public interface TermCurrencyRepository extends JpaRepository<TermCurrency, Integer> {
    @Nullable
    @Query(value = "SELECT  term_currency.* FROM term_currency  INNER JOIN terminals  ON term_currency.id_terminals = terminals.id_terminals WHERE terminals.id_terminals = :idTerminal", nativeQuery = true)
    TermCurrency findByTerminals(@Param("idTerminal") Integer idTerminal);
    /*@Nullable
    List<TermCurrency> findByIdTerminalsLike(Integer idTerminals);*/
}
