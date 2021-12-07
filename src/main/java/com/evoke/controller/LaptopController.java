package com.evoke.controller;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evoke.entity.Brand;
import com.evoke.entity.Laptop;
import com.evoke.entity.LaptopRequest;
import com.evoke.repo.BrandRepository;
import com.evoke.repo.LaptopRepository;

@RestController
@ControllerAdvice
public class LaptopController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LaptopRepository lRepo;

	@Autowired
	private BrandRepository bRepo;

	@PostMapping("/laptops/save")
	public ResponseEntity<Laptop> saveData(@RequestBody LaptopRequest req) {

		Brand brand = new Brand();
		brand.setBrandName(req.getBrand());

		brand = bRepo.save(brand);

		Laptop laptop = new Laptop(req);
		laptop.setBrand(brand);

		laptop = lRepo.save(laptop);

		return new ResponseEntity<Laptop>(laptop, HttpStatus.CREATED);

	}

	@GetMapping
	public Laptop save(@RequestParam Long id) {
		logger.debug("Entered in Fetch method ");

		return lRepo.findById(id).orElseThrow();

	}

	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<Object> exception(NoSuchElementException exception) {
		return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	}

}