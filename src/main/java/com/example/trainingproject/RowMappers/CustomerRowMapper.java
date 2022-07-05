package com.example.trainingproject.RowMappers;

import com.example.trainingproject.Entities.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper  implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

        Customer customer = new Customer();
        customer.setId(rs.getInt("customer_id"));
        customer.setFullName(rs.getString("full_name"));
        customer.setLocation(rs.getString("address"));
        customer.setPhone(rs.getString("phone"));

        return customer;

    }
}
