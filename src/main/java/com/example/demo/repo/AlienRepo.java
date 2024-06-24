package com.example.demo.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import  com.example.demo.model.Alien;

 @Repository
public class AlienRepo {

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    private JdbcTemplate template ;

    public void save(Alien alien){

        String sql ="insert into alien (id ,name ,Tech) values(?,?,?)";



        template.update(sql,alien.getId(),alien.getName(),alien.getTech() );


    }



    public List<Alien> findAll(){

        String sql = "select * from alien";


        RowMapper<Alien> mapper = new RowMapper<Alien>() {
            public Alien mapRow(ResultSet rs , int rowNum) throws SQLException{
                Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));
                return a;
            }
            
        };

        List<Alien> ll = template.query(sql, mapper);
        return ll;
    }
    
}
