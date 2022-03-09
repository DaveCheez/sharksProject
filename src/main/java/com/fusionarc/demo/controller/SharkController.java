package com.fusionarc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fusionarc.demo.entity.Shark;
import com.fusionarc.demo.service.SharkService;

@RestController
@RequestMapping("/shark")
public class SharkController {

	private SharkService service;
	
	@Autowired
	public SharkController(SharkService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Shark> createShark(@RequestBody Shark shark) {
		return new ResponseEntity<Shark>(this.service.create(shark), HttpStatus.CREATED);
	}
	
	// Read All
	@GetMapping("/readAll")
	public ResponseEntity<List<Shark>> readAllSharks() {
		return new ResponseEntity<List<Shark>>(this.service.readAll(), HttpStatus.OK);
	}

	// Read by Id
	// @PathVariable allows us to pass a variable (in this case ID) to the path &
	// the service.readById method
	@GetMapping("/readById/{id}")
	public ResponseEntity<Shark> readById(@PathVariable long id, @RequestBody Shark shark) {
		return new ResponseEntity<Shark>(this.service.readById(id), HttpStatus.OK);
	}

	// Update
	// update requires both RequestBody and PathVariable as it takes in the id, and
	// also passes through the new object information
	@PutMapping("/update/{id}")
	public ResponseEntity<Shark> updateShark(@PathVariable long id, @RequestBody Shark shark) {
		return new ResponseEntity<Shark>(this.service.update(id, shark), HttpStatus.ACCEPTED);
	}

	// Delete
	// Ternary operator, IF service.delete goes through (deletes the id), return no
	// content, ELSE return not found
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteShark(@PathVariable long id) {
		return (this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) : 
			new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
	
}