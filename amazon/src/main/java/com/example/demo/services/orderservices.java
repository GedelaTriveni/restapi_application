package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.order;
import com.example.demo.repository.orderrepository;

@Service
public class orderservices {
	@Autowired
	orderrepository repo;

	public order adding(order O) {
		return repo.save(O);
	}

	public Iterable<order> addingAll(List<order> o) {
		return repo.saveAll(o);
	}

	public List<order> getAll() {
		return (List<order>) repo.findAll();
	}

	public Optional<order> singlefetch(int id) {
		return repo.findById(id);
	}

	public List<order> mutlifetch() {
		return (List<order>) repo.findAll();
	}

	public String deletebyId(int id) {
		repo.deleteById(id);
		return "Successfully Deleted" + id;
	}

	public order updatedata(order ord) {
		int id = ord.getId();
		order o = repo.findById(id).get();
		o.setId(ord.getId());
		o.setName(ord.getName());
		o.setAddress(ord.getAddress());
		o.setEmail(ord.getEmail());
		o.setAmount(ord.getAmount());
		return repo.save(o);
	}
}
