package com.example.jdbcex.service;

import java.util.List;

import com.example.jdbcex.Laptop.Laptop;

public interface ServiceEx {
	int insertLaptop(Laptop laptop);

	Laptop getLaptopById(int id);

	List<Laptop> getAllLaptops();

	int updateLaptop(Laptop laptop);

	int deleteLaptop(int id);
}
