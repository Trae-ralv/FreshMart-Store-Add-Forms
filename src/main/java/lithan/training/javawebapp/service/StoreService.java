package lithan.training.javawebapp.service;

import lithan.training.javawebapp.dao.StoreDAO;
import lithan.training.javawebapp.model.StoreModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final StoreDAO storeDAO;

    @Autowired
    public StoreService(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    public void addStore(StoreModel storeModel) {
        storeDAO.addStore(storeModel);
    }

    public List<StoreModel> getAllStores() {
        return storeDAO.getAllStores();
    }
}