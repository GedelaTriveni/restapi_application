package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.login;
import com.example.demo.repository.loginrepository;

@Service
public class loginservices {
@Autowired
loginrepository repo;
public login adding(login log) {
	return repo.save(log);
}
public Iterable<login> addingall(List<login> log) {
	return repo.saveAll(log);
}
public Optional<login> singlefetch(int id) {
			return repo.findById(id);

	}
public List<login> mutlifetch() {
	return (List<login>) repo.findAll();
}
public String deleteid(int id) {
	repo.deleteById(id);
	return "sucessfully deleted" + id;
}
public login updatedata(login log) {
	int id=log.getId();
	login l=repo.findById(id).get();
	l.setId(log.getId());
	l.setEmail(log.getEmail());
	l.setPassword(log.getPassword());
	return repo.save(l);
}
}