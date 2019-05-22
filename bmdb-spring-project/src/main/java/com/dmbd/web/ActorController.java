package com.dmbd.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmbd.business.Actor;
import com.dmbd.business.JsonResponse;
import com.dmbd.db.ActorRepository;

	@RestController
	@RequestMapping("/actors")
	public class ActorController {

		@Autowired
		private ActorRepository actorRepo;
		
		@GetMapping("/")
		public JsonResponse getAll() {
			JsonResponse jr = null;
			try {
				jr = JsonResponse.getInstance(actorRepo.findAll());
			} catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
			return jr;

		}
		
		@GetMapping("/{id}")
		public JsonResponse get(@PathVariable int id) {
			JsonResponse jr = null;
			try {
				Optional<Actor> a = actorRepo.findById(id);
				if (a.isPresent())
					jr = JsonResponse.getInstance(a);
				else
					jr = JsonResponse.getInstance("No actor found for id" + id);
			} catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
			return jr;
		}
		
		@PostMapping("/")
		public JsonResponse add(@RequestBody Actor a) {
			JsonResponse jr = null;
			try {
				jr = JsonResponse.getInstance(actorRepo.save(a));
			} catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
			return jr;
		}
		
		@PutMapping("/")
		public JsonResponse update(@RequestBody Actor a) {
			JsonResponse jr = null;
			try {
				if (actorRepo.existsById(a.getId())) {
					jr = JsonResponse.getInstance(actorRepo.save(a));
				}	
				else {
					jr = JsonResponse.getInstance("Actor ID: " + a.getId() +"does not exist"  
											+ "and you are attempting to save it.");
				}
			} catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
			return jr;
		}
}
