package com.arindam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arindam.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
Optional<Inventory> findByPcode(String pcode);
}
