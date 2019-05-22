package com.mma.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mma.business.JsonResponse;
import com.mma.business.Product;
import com.mma.db.ProductRepository;

@RestController // removes requirement of adding @responsebody to each method
@RequestMapping("/products") // for a base URL mapping to point traffic to this controller
public class ProductController {

	// create instance variable & auto wire repository to wire to CRUD functions
	@Autowired
	private ProductRepository productRepo;

	@GetMapping("/")
	public JsonResponse getAll() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(productRepo.findAll());
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;

	}

	@GetMapping("/{id}")
	public JsonResponse get(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			Optional<Product> p = productRepo.findById(id);
			if (p.isPresent())
				jr = JsonResponse.getInstance(p);
			else
				jr = JsonResponse.getInstance("No product found for id" + id);
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@GetMapping("")
	public JsonResponse getByCode(@RequestParam String code) {
		JsonResponse jr = null;
		try {
			Optional<Product> p = productRepo.findByCode(code);
			if (p.isPresent())
				jr = JsonResponse.getInstance(p);
			else
				jr = JsonResponse.getInstance("No product found for code" + code);
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@PostMapping("/")
	public JsonResponse add(@RequestBody Product p) {
		JsonResponse jr = null;
		// NOTE: may need to enhance exception handling
		// if more than 1 exception type needs to be caught
		try {
			jr = JsonResponse.getInstance(productRepo.save(p));
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@PutMapping("/")
	public JsonResponse update(@RequestBody Product p) {
		JsonResponse jr = null;
		// NOTE: may need to enhance exception handling
		// if more than 1 exception type needs to be caught
		try {
			if (productRepo.existsById(p.getId())) {
				jr = JsonResponse.getInstance(productRepo.save(p));
			} else {
				jr = JsonResponse.getInstance(
						"Product ID: " + p.getId() + "does not exist" + "and you are attempting to save it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@DeleteMapping("/")
	public JsonResponse delete(@RequestBody Product p) {
		JsonResponse jr = null;
		// NOTE: may need to enhance exception handling
		// if more than 1 exception type needs to be caught
		try {
			if (productRepo.existsById(p.getId())) {
				productRepo.delete(p);
				jr = JsonResponse.getInstance("Product deleted.");
			} else {
				jr = JsonResponse.getInstance(
						"Product ID: " + p.getId() + "does not exist" + "and you are attempting to delete it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

}
