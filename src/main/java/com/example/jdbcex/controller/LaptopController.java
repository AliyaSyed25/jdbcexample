package com.example.jdbcex.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.example.jdbcex.Laptop.Laptop;
import com.example.jdbcex.service.ServiceEx;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
	private static final Logger logger = LoggerFactory.getLogger(LaptopController.class);
	@Autowired
	private ServiceEx service;

	@PostMapping("/insert")
	public ResponseEntity<String> insertLaptop(@RequestBody Laptop laptop) {
		int rows = service.insertLaptop(laptop);
		if (rows > 0) {
			logger.info("Laptop inserted successfully", laptop);
			return ResponseEntity.ok("insertion succesful");
		} else {
			logger.info("Laptop insertion failed", laptop);
			return ResponseEntity.ok("failed to insert");
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateLaptop(@PathVariable int id, @RequestBody Laptop laptop) {
		laptop.setId(id);
		int rows = service.updateLaptop(laptop);
		if (rows > 0) {
			logger.info("Laptop updated successfully", laptop);
			return ResponseEntity.ok("UPDATION SUCCESSFUL");

		} else {
			logger.warn("failed to update laptop,np laptop with given id", laptop);
			return ResponseEntity.ok("FAILED TO UPDATE,NO LAPTOP WITH SUCH ID");
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteLaptop(@PathVariable int id) {
		// laptop.setId(id);
		int rows = service.deleteLaptop(id);
		if (rows > 0) {
			logger.info("Laptop deleted successfully", id);
			return ResponseEntity.ok("DELETION SUCCESSFUL");
		} else {
			logger.warn("failed to delete,no laptop with that given id", id);
			return ResponseEntity.ok(" DELETION FAILED, NO LAPTOP WITH SUCH ID");
		}
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<?> getLaptopById(@PathVariable int id) {
		Laptop laptop = service.getLaptopById(id);
		if (laptop != null) {
			logger.info("Laptop successfully fetched with the given  id", id);
			return ResponseEntity.ok(laptop);
		} else {
			logger.warn("failed to fetch Laptop with the given id ", id);
			return ResponseEntity.ok("no laptop with the given id");
			
		}
	}

	@GetMapping("/fetch")
	public ResponseEntity<List<Laptop>> getAllLaptops() {
		List<Laptop> laptops = service.getAllLaptops(); // This should return a List<Laptop>
		if (laptops.isEmpty()) {
			logger.info("List of Laptops fetched successfully");

			return ResponseEntity.noContent().build();
		}
		logger.warn("Failed to fetch List of Laptops");
		return ResponseEntity.ok(laptops);
	}
}