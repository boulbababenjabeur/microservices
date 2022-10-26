package tn.esprit.ms.reclamation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.ms.reclamation.entity.Reclamation;
import tn.esprit.ms.reclamation.service.ReclamationService;



@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/Reclamation")
public class ReclamationController {
	@Autowired
	ReclamationService reclamationService;
	
	// http://localhost:8088/api/Reclamation/retrieveAllReclamations
	@GetMapping("/retrieveAllReclamations")
	@ResponseBody
	public List<Reclamation> getReclamations() {
		List<Reclamation> listReclamations = reclamationService.retrieveAllReclamations();
		return listReclamations;
	}
	
	
	// http://localhost:8088/api/Reclamation/deleteReclamation/{id}
	@DeleteMapping("/deleteReclamation/{id}")
	@ResponseBody
	public void deleteReclamation(@PathVariable("id") Long id) {
		reclamationService.deleteReclamation(id);
	}
	
	// http://localhost:8088/api/Reclamation/retrieveReclamation/{id}
			@GetMapping("/retrieveReclamation/{id}")
			@ResponseBody
			public Reclamation getReclamation(@PathVariable("id") Long id) {
				Reclamation listReclamation = reclamationService.retrieveReclamation(id);
				return listReclamation;
			}
//http://localhost:8088/api/Reclamation/modify-reclamation
			@CrossOrigin("*")
					@PutMapping("/modify-reclamation")
					@ResponseBody
					public Reclamation modifyReclamation(@RequestBody Reclamation c) {
		        System.out.println(c);

						return reclamationService.updateReclamation(c);
					}
		@CrossOrigin("*")
//http://localhost:8088/api/Reclamation/add-reclamation
				@PostMapping("/add-reclamation")
				@ResponseBody
				public Reclamation addReclamation(@RequestBody Reclamation c){
					Reclamation reclamation = reclamationService.addReclamation(c);
					return reclamation;

				}
	
}
