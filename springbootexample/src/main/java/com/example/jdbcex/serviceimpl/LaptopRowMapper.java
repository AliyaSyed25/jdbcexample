package com.example.jdbcex.serviceimpl;
import org.springframework.jdbc.core.RowMapper;

import com.example.jdbcex.Laptop.Laptop;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LaptopRowMapper implements RowMapper<Laptop> {
@Override
	public Laptop mapRow(ResultSet rs,int rowNum) throws SQLException {
		Laptop laptop=new Laptop();
		laptop.setId(rs.getInt("id"));
		laptop.setName(rs.getString("name"));
		laptop.setEmail(rs.getString("email"));
		return laptop;
	}

	

}
