package com.evoke.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_laptops")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	private BigDecimal price;
	
	public Laptop(LaptopRequest request) {
		this.name = request.getName();
		this.price = request.getPrice(); 
	}
	
}