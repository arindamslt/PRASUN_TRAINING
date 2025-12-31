package com.arindam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindam.entity.Inventory;
import com.arindam.repository.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
private InventoryRepository irepo;
	public void createInventory(String pcode,Integer pqty)
	{
		Inventory inv=new Inventory();
		inv.setPcode(pcode);
		inv.setAvlqty(pqty);
		inv.setResvqty(0);
		irepo.save(inv);
		
	}
	public void reserve(String pcode,Integer pqty)
	{
		
		Inventory inv=irepo.findByPcode(pcode).orElseThrow();
		if(inv.getAvlqty()<pqty)
		{
			throw new RuntimeException("OUT OF STOCK");
		}
		inv.setResvqty(pqty);
		inv.setAvlqty(inv.getAvlqty()-pqty);
		irepo.save(inv);
	}
	public void release(String pcode,Integer pqty)
	{
		Inventory inv=irepo.findByPcode(pcode).orElseThrow();
		inv.setResvqty(inv.getResvqty()-pqty);
		inv.setAvlqty(inv.getAvlqty()+pqty);
		irepo.save(inv);
	}
}
