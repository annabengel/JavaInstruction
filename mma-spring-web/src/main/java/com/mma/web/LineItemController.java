package com.mma.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mma.business.Invoice;
import com.mma.business.JsonResponse;
import com.mma.business.LineItem;
import com.mma.db.LineItemRepository;

@RestController 
@RequestMapping("/lineitems")
public class LineItemController {

	@Autowired
	private LineItemRepository lineItemRepo;

	@GetMapping("/")
	public JsonResponse getAll() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(lineItemRepo.findAll());
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;

	}
	
	@GetMapping("/{id}")
	public JsonResponse get(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			Optional<LineItem> l = lineItemRepo.findById(id);
			if (l.isPresent())
				jr = JsonResponse.getInstance(l);
			else
				jr = JsonResponse.getInstance("No line item found for id" + id);
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@PostMapping("/")
	public JsonResponse add(@RequestBody LineItem l) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(lineItemRepo.save(l));
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@PutMapping("/")
	public JsonResponse update(@RequestBody LineItem l) {
		JsonResponse jr = null;
		try {
			if (lineItemRepo.existsById(l.getId())) {
				jr = JsonResponse.getInstance(lineItemRepo.save(l));
			}	
			else {
				jr = JsonResponse.getInstance("Line Item ID: " + l.getId() +"does not exist"  
										+ "and you are attempting to save it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@DeleteMapping("/")
	public JsonResponse delete(@RequestBody LineItem l) {
		JsonResponse jr = null;
		try {
			if (lineItemRepo.existsById(l.getId())) {
				lineItemRepo.delete(l);
				jr = JsonResponse.getInstance("Line Item deleted.");
			}	
			else {
				jr = JsonResponse.getInstance("Line item ID: " + l.getId() +"does not exist"  
										+ "and you are attempting to delete it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
}
