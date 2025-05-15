package lithan.training.javawebapp.dao;

import lithan.training.javawebapp.model.StoreModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StoreDAO {
    private final List<StoreModel> stores = new ArrayList<>();

    public void addStore(StoreModel storeModel) {
        stores.add(storeModel);
    }

    public List<StoreModel> getAllStores() {
        return new ArrayList<>(stores);
    }
}

