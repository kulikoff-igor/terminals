package by.diplom.repository;

import by.diplom.model.MerchTab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * Created by admin on 12.04.2018.
 */
public interface MerchTabRepository  extends JpaRepository<MerchTab, Integer> {
    @Nullable
    List<MerchTab> findByMerchNameContaining(String merchName);
}
