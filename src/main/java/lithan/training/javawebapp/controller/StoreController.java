package lithan.training.javawebapp.controller;

import lithan.training.javawebapp.model.StoreModel;
import lithan.training.javawebapp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller for handling store-related requests
@Controller
public class StoreController {

    private final StoreService storeService;

    // Constructor injection for StoreService
    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    // Homepage mapping
    @GetMapping("/")
    public String index() {
        return "index"; // Returns index.jsp
    }

    // Show form to add a new store
    @GetMapping("/stores/add")
    public String showAddStoreForm() {
        return "add-store"; // Returns add-store.jsp
    }

    // Handle form submission to add a store
    @PostMapping("/stores")
    public String addStore(
            @RequestParam String name,
            @RequestParam String phoneNumber,
            @RequestParam String localities,
            Model model) {
        StoreModel store = new StoreModel();
        store.setName(name);
        store.setPhoneNumber(phoneNumber);
        store.setLocalities(localities.split(","));
        storeService.addStore(store);
        return "redirect:/stores"; // Redirect to store list
    }

    // Display list of all stores
    @GetMapping("/stores")
    public String listStores(Model model) {
        model.addAttribute("stores", storeService.getAllStores());
        return "store-list"; // Returns store-list.jsp
    }

    // AJAX endpoint to get store by ID
    @GetMapping("/stores/{id}")
    @ResponseBody
    public ResponseEntity<StoreModel> getStore(@PathVariable Long id) {
        StoreModel store = storeService.getStoreById(id);
        return store != null ? ResponseEntity.ok(store) : ResponseEntity.notFound().build();
    }

    // AJAX endpoint to update a store
    @PostMapping("/stores/{id}/edit")
    @ResponseBody
    public ResponseEntity<Void> updateStore(@PathVariable Long id, @RequestBody StoreModel store) {
        store.setId(id);
        storeService.updateStore(store);
        return ResponseEntity.ok().build();
    }

    // AJAX endpoint to delete a store
    @DeleteMapping("/stores/{id}/delete")
    @ResponseBody
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.ok().build();
    }

    // AJAX endpoint to search stores by locality
    @GetMapping("/stores/search")
    @ResponseBody
    public List<StoreModel> searchStores(@RequestParam String locality) {
        return storeService.searchStoresByLocalities(locality);
    }
}