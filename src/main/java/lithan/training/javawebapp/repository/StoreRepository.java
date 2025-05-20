package lithan.training.javawebapp.repository;

import lithan.training.javawebapp.model.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// JPA repository for handling store data
@Repository
public interface StoreRepository extends JpaRepository<StoreModel, Long> {
    // Custom query to search stores by localities using native SQL
    @Query(value = "SELECT * FROM stores WHERE localities LIKE %:locality%", nativeQuery = true)
    List<StoreModel> findByLocalitiesContaining(String locality);
}

