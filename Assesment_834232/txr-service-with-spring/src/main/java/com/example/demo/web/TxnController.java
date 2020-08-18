package com.example.demo.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Txn;
import com.example.demo.repository.TransactionRepository;

@Controller
public class TxnController {
	
	@Autowired
	private TransactionRepository tr;

	@GetMapping(value = "txns")
	public String getAllTxns(@RequestParam String filter, Model model) {

		List<Txn> txns = new ArrayList<Txn>();
		if (filter.equals("all")) {
			txns = tr.findAll();
		}

		model.addAttribute("txns", txns); // request scope

		return "statement";

	}

}
