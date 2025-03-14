package com.example.jdbcex.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.jdbcex.Laptop.Laptop;
import com.example.jdbcex.config.SqlConfig;
import com.example.jdbcex.service.ServiceEx;

@Service
public class ServiceImpl implements ServiceEx {
	private static final Logger logger=LoggerFactory.getLogger(ServiceImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SqlConfig sqlConfig;

	public int insertLaptop(Laptop laptop) {
		logger.info("inserting a laptop:",laptop);
		return jdbcTemplate.update(sqlConfig.getInsert(), laptop.getId(), laptop.getName(), laptop.getEmail());
	}

	@Override
	public int updateLaptop(Laptop laptop) {
		logger.info("updating the laptop with id",laptop.getId());
		return jdbcTemplate.update(sqlConfig.getUpdate(), laptop.getName(), laptop.getEmail(), laptop.getId());
	}

	@Override
	public int deleteLaptop(int id) {
		logger.info("deleting a laptop with the given id",id);
		return jdbcTemplate.update(sqlConfig.getDeleteById(), id);
	}

	@Override
	public Laptop getLaptopById(int id) {
		logger.info("");
		try {
			return jdbcTemplate.queryForObject(sqlConfig.getGetById(), new LaptopRowMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			return null;

		}
	}

	@Override
	public List<Laptop> getAllLaptops() {
		return jdbcTemplate.query(sqlConfig.getGetAll(), new LaptopRowMapper());
	}

}
