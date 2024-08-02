package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.register;
import com.example.demo.repository.registerrepository;
@Service
public class registerservices {
	@Autowired
	registerrepository repo;
	public register adding(register reg) {
		return repo.save(reg);
	}
	public Iterable<register> addingall(List<register> reg) {
		return repo.saveAll(reg);
	}
	public Optional<register> singlefetch(int id) {
				return repo.findById(id);

		}
	public List<register> mutlifetch() {
		return (List<register>) repo.findAll();
	}
	public String deleteid(int id) {
		repo.deleteById(id);
		return "sucessfully deleted" + id;
	}
	public register updatedata(register reg) {
		int id=reg.getId();
		register l=repo.findById(id).get();
		l.setId(reg.getId());
		l.setEmail(reg.getEmail());
		l.setPassword(reg.getPassword());
		return repo.save(reg);
	}
}
