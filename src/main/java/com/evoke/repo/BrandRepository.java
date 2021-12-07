package com.evoke.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evoke.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{

}