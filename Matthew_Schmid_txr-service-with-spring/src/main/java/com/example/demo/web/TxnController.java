package com.example.demo.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Txn;
import com.example.demo.repository.AccountRepositoryTxn;


@Controller
public class TxnController {
	
	
	@Autowired
	private AccountRepositoryTxn accountRepositoryTxn;
	
	@GetMapping(value = "day_select")
	public String filter_select(@RequestParam String filter,
								@RequestParam String Day,
			Model model 
			) {
		
		List<Txn> txns = new ArrayList<Txn>();
		if (filter.equals("all")) {
			txns.addAll(accountRepositoryTxn.findAll());
		}
		
		if (filter.equals("Day")) {
			txns.addAll(accountRepositoryTxn.findAll());
			txns = (filterTxn(txns, Day));

		}	
		
		model.addAttribute("day_select", txns); // request scope
		
		
		return "statement_day";
	}

	@GetMapping(value = "txns")
	public String getAllTxns(@RequestParam String filter, Model model) {
		


		List<Txn> txns = new ArrayList<Txn>();
		if (filter.equals("all")) {
			txns.addAll(accountRepositoryTxn.findAll());
		}
		

			

		model.addAttribute("txns", txns); // request scope

		return "statement";

	}
	
	
	public static List<Txn> filterTxn(List<Txn> txns, String day) {
		

		
		List<Txn> result = new ArrayList<Txn>();
		for (Txn txn : txns) {
			if (txn.getLocalDateTime_Daydb().equals(day))
				result.add(txn);
		}
		return result;
	}


}