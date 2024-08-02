package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.payment;
import com.example.demo.repository.paymentrepository;

@Service
public class paymentservices {
	@Autowired
	paymentrepository repo;
	public payment adding(payment pay) {
		return repo.save(pay);
	}
	public Iterable<payment> addingall(List<payment> pay) {
		return repo.saveAll(pay);
	}
	public Optional<payment> singlefetch(int id) {
				return repo.findById(id);

		}
	public List<payment> mutlifetch() {
		return (List<payment>) repo.findAll();
	}
	public String deleteid(int id) {
		repo.deleteById(id);
		return "sucessfully deleted" + id;
	}
	public payment updatedata(payment pay) {
		int id=pay.getId();
		payment l=repo.findById(id).get();
		l.setId(pay.getId());
		l.setName(pay.getName());
		l.setCardnumber(pay.getCardnumber());
		l.setCvv(pay.getCvv());
		return repo.save(pay);
	}
}
