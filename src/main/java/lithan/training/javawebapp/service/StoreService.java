package lithan.training.javawebapp.service;

import lithan.training.javawebapp.model.StoreModel;
import lithan.training.javawebapp.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service layer for handling store business logic
@Service
public class StoreService {

    private final StoreRepository storeRepository;

    // Constructor injection for StoreRepository
    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    // Add a new store
    public void addStore(StoreModel store) {
        storeRepository.save(store);
    }

    // Get all stores
    public List<StoreModel> getAllStores() {
        return storeRepository.findAll();
    }

    // Get a store by ID
    public StoreModel getStoreById(Long id) {
        Optional<StoreModel> store = storeRepository.findById(id);
        return store.orElse(null);
    }

    // Update an existing store
    public void updateStore(StoreModel store) {
        storeRepository.save(store);
    }

    // Delete a store by ID
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }

    // Search stores by locality
    public List<StoreModel> searchStoresByLocalities(String locality) {
        return storeRepository.findByLocalitiesContaining(locality);
    }
}