package by.diplom.repository;

import by.diplom.model.TransScheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransSchemeRepository extends JpaRepository<TransScheme, Integer> {
    @Query(value = "DELETE FROM trans_scheme WHERE number_trans_scheme =  :numberTransScheme", nativeQuery = true)
    void deleteByNumberTransScheme(@Param("numberTransScheme") Integer numberTransScheme);
    @Query(value = "SELECT  * FROM trans_scheme WHERE trans_scheme.number_trans_scheme = :numberTransScheme", nativeQuery = true)
    List<TransScheme> findByNumberTransScheme(@Param("numberTransScheme") Integer numberTransScheme);
}
