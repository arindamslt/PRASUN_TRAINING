package com.arindam.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="inventory-service",url="http://localhost:8084")
public interface InventoryClient {
	@PostMapping("/inventory/add/{pcode}/{pqty}")
    void createInventory(@PathVariable String pcode,@PathVariable Integer pqty);
	
}
