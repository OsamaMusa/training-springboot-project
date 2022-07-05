package com.example.trainingproject.Repositories;

import com.example.trainingproject.Entities.Customer;
import com.example.trainingproject.IRepositories.ICustomerRepository;
import com.example.trainingproject.RowMappers.CustomerRowMapper;
import lombok.AllArgsConstructor;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomerRepository implements ICustomerRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Override
    public List<Customer> findCustomerByFullName(String fullName) {
        String sql = "SELECT * from Customer where full_name = :full_name";
        SqlParameterSource source = new MapSqlParameterSource("full_name",fullName);
        List<Customer> customers =  template.query(sql,source,new CustomerRowMapper());

        if(customers == null)
            return  new ArrayList<>();

        return customers;


    }

    @Override
    public List<Customer> findAll() {

        String sql = "SELECT * from Customer";

        List<Customer> customers = template.query(
                sql,
                new CustomerRowMapper());

        return customers;
    }

    @Override
    public Optional<Customer> findById(int id) {
        String sql = "SELECT * from Customer where customer_id = :customer_id";
        SqlParameterSource source = new MapSqlParameterSource("customer_id",id);
        Customer customer =  template.queryForObject(sql,source,new CustomerRowMapper());

        if(customer == null)
            return  Optional.empty();

        return Optional.of(customer);

    }

    @Override
    public Customer insert(Customer customer) {
        String sql = "insert into Customer (full_name , address, phone ) values (:full_name,:address,:phone)";
        SqlParameterSource source = new MapSqlParameterSource("full_name",customer.getFullName())
                .addValue("address",customer.getLocation())
                .addValue("phone",customer.getPhone());

        template.update(sql,source);
        return customer;

    }

    @Override
    public Customer update(Customer customer) {
        String sql = "update  Customer set full_name  =:full_name and address =:address and phone=:phone where customer_id = :customer_id";
        SqlParameterSource source = new MapSqlParameterSource("full_name",customer.getFullName())
                .addValue("customer_id",customer.getId())
                .addValue("address",customer.getLocation())
                .addValue("phone",customer.getPhone());

        template.update(sql,source);
        return  customer;
    }


    @Override
    public void delete(int id) {
        String sql = "delete from Customer where customer_id = :customer_id";
        SqlParameterSource source = new MapSqlParameterSource("customer_id",id);
        template.update(sql,source);
    }
}
