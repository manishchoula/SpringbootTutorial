package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	@Autowired
	CustomerRepo repo;

	@RequestMapping("/")
	public String adding() {
		return "template";
	}

	@RequestMapping("/details")
	public String adding(Customers customers) {
		repo.save(customers);
		return "template";
	}

	@RequestMapping("/getdetails")
	public String getDetails() {
		return "ViewCustomers";
	}

	@PostMapping("/getdetails")
	public ModelAndView getdetails(@RequestParam int cid) {
		ModelAndView mv = new ModelAndView("Retrieve");
		Customers customers = repo.findById(cid).orElse(null);
		mv.addObject(customers);
		return mv;
	}

	// method to retrieve all the customers
	@GetMapping("/customers")
	@ResponseBody
	public List<Customers> getCustomers() {
		System.out.println(repo.findAll());
		return repo.findAll();
	}

	// method to retrieve customers with id
	@RequestMapping("/customers/{cid}")
	@ResponseBody
	public Optional<Customers> getCustomersById(@PathVariable("cid") int cid) {
		System.out.println(repo.findById(cid));
		return repo.findById(cid);
	}

	@PostMapping("/customers")
	public Customers saveCustomer(@RequestBody Customers customers) {
		// System.out.println(repo.findAll()) ;
		// return repo.findAll();
		repo.save(customers);
		return customers;
	}

	@DeleteMapping("/customers/{cid}")
	public Customers deleteCustomers(@PathVariable("cid") int cid) {
		// repo.deleteById(cid);
		// return "'Deleted Customer with id'+ cid";
		@SuppressWarnings("deprecation")
		Customers cust = repo.getOne(cid);
		repo.delete(cust);
		return cust;

	}

	@PutMapping(path = "/customers", consumes = { "application/json" })
	public Customers updateCustomers(@RequestBody Customers customers) {
		repo.save(customers);
		return customers;
	}
}
