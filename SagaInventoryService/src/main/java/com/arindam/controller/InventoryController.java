package com.arindam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arindam.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	@Autowired
	private InventoryService iservice;
	@PostMapping("/add/{pcode}/{pqty}")
    public String createInventory(@PathVariable String pcode,@PathVariable Integer pqty)
    {
    	iservice.createInventory(pcode, pqty);
    	return "INVENTORY CREATED";
    }
	@PutMapping("/reserve/{pcode}/{pqty}")
	public String reserve(@PathVariable String pcode,@PathVariable Integer pqty)
	{
		iservice.reserve(pcode, pqty);
		return "INVENTORY RESERVED";
	}
	@PutMapping("/release/{pcode}/{pqty}")
	public String release(@PathVariable String pcode,@PathVariable Integer pqty)
	{
		iservice.release(pcode, pqty);
		return "INVENTORY RELEASED";
	}
}
