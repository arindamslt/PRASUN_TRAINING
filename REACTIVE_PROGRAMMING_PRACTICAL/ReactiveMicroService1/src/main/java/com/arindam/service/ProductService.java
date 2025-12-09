package com.arindam.service;

import org.springframework.stereotype.Service;

import com.arindam.model.Product;
import com.arindam.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
private ProductRepository prepo;
public ProductService(ProductRepository prepo)
{
	this.prepo=prepo;
}
public Mono<Product> addData(Product p)
{
	return prepo.save(p);
}
public Flux<Product> getData()
{
	return prepo.findAll();
}
public Mono<Product> getPidDetails(Integer pid)
{
	return prepo.findById(pid);
}
public Mono<String> deleteData(Integer pid)
{
	/*return prepo.findById(pid)
			.flatMap(ps->prepo.delete(ps)
			 .then(Mono.just("DATA DELETED SUCCESSFULLY:"+pid))
			 .switchIfEmpty(Mono.error(new RuntimeException("NO DATA FOUND:"+pid))));*/
	return prepo.findById(pid)
			.flatMap(p->prepo.delete(p)
			.then(Mono.just("DATA DELETED SUCCESSFULLY:"+pid)))
			.switchIfEmpty(Mono.error(new RuntimeException("PRODUCT NOT FOUND:"+pid)));
			
}
public Mono<Product> updateData(Integer pid,Product p)
{
	return prepo.findById(pid)
			.flatMap(ps->{
				ps.setPname(p.getPname());
				ps.setPrice(p.getPrice());
				return prepo.save(ps);
			});
}
}
