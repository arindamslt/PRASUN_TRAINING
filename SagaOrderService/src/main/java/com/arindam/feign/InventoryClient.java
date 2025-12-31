package com.arindam.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="inventory-service",url="http://localhost:8084")
public interface InventoryClient {
	@PutMapping("/inventory/reserve/{pcode}/{pqty}")
	void reserve(@PathVariable String pcode,@PathVariable Integer pqty);
	@PutMapping("/release/{pcode}/{pqty}")
	void release(@PathVariable String pcode,@PathVariable Integer pqty);
}
