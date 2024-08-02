package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.order;
import com.example.demo.services.orderservices;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")

public class ordercontroller {
    @Autowired
    orderservices services;
    @PostMapping("/adding")
    public order adding(@RequestBody order O) {
   	 return services.adding(O);
    }
    @PostMapping("/addingall")
    public Iterable<order> addingAll(@RequestBody List<order> o) {
   	 return services.addingAll(o);
    }
    @GetMapping("/multifetching")
	public List<order> multifetch() {
		return services.mutlifetch();
	}
	@GetMapping("/singlefetching/{id}")
	public Optional<order> singlefetch(@PathVariable int id) {
		return services.singlefetch(id);
	}
	@DeleteMapping("/deleting/{id}")
	public String deleteid(@PathVariable int id) {
		return services.deletebyId(id);
	}
	@PutMapping("/update")
	public order updatedata( @RequestBody  order ord) {
		return services.updatedata(ord);
	}
    


}
