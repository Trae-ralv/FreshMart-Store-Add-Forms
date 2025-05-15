package lithan.training.javawebapp.controller;

import lithan.training.javawebapp.model.StoreModel;
import lithan.training.javawebapp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StoreController {

	private final StoreService storeService;

	@Autowired
	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/stores/add")
	public String showAddStoreForm() {
		return "add-store";
	}

	@PostMapping("/stores")
	public String addStore(@RequestParam String storename, @RequestParam String phoneNumber, @RequestParam String localities,
			Model model) {
		StoreModel storeModel = new StoreModel();
		storeModel.setName(storename);
		storeModel.setPhoneNumber(phoneNumber);
		storeModel.setLocalities(localities.split(","));
		storeService.addStore(storeModel);
		return "redirect:/stores";
	}

	@GetMapping("/stores")
	public String listStores(Model model) {
		model.addAttribute("stores", storeService.getAllStores());
		return "store-list";
	}
}

