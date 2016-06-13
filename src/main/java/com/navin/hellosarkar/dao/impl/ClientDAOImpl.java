/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navin.hellosarkar.dao.impl;

import com.navin.hellosarkar.dao.ClientDAO;
import com.navin.hellosarkar.dbutil.DBConnection;
import com.navin.hellosarkar.entity.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Navin
 */
public class ClientDAOImpl implements ClientDAO{
private DBConnection db=new DBConnection();
    @Override
    public int insert(Client t) throws ClassNotFoundException, SQLException {
        String sql="INSERT INTO tbl_client(first_name,last_name,email) values(?,?,?)";
        
        db.open();
        PreparedStatement stmt=db.initStatement(sql);
        stmt.setString(1, t.getFirstName());
        stmt.setString(2, t.getLastName());
        stmt.setString(3, t.getEmail());
        
        int result=db.executeUpdate();
        
        db.close();
        return result;
        
    }

    @Override
    public int update(Client t) throws ClassNotFoundException, SQLException {
        String sql="UPDATE tbl_client SET first_name=?,last_name=?,email=? WHERE id=?";
        
        db.open();
        PreparedStatement stmt=db.initStatement(sql);
        stmt.setString(1, t.getFirstName());
        stmt.setString(2, t.getLastName());
        stmt.setString(3, t.getEmail());
        stmt.setInt(4, t.getId());
        
        int result=db.executeUpdate();
        
        db.close();
        return result;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
         String sql="DELETE tbl_client WHERE id=?";
        
        db.open();
        PreparedStatement stmt=db.initStatement(sql);
       
        stmt.setInt(1, id);
        
        int result=db.executeUpdate();
        
        db.close();
        return result;
    }

    @Override
    public Client getById(int id) throws ClassNotFoundException, SQLException {
        Client c=null;
        String sql="SELECT *FROM tbl_client WHERE id=?";
        
        db.open();
        PreparedStatement stmt=db.initStatement(sql);
        
        ResultSet rs=db.executeQuery();
        while(rs.next()){
        c=new Client();
        c.setId(rs.getInt("id"));
        c.setFirstName(rs.getString("first_name"));
        c.setLastName(rs.getString("last_name"));
        c.setEmail(rs.getString("email"));
        
        }
         db.close();
        return c;
    }

    @Override
    public List<Client> getAll() throws ClassNotFoundException, SQLException {
        List<Client>clientList=new ArrayList<>(); 
        String sql="SELECT *FROM tbl_client";
        
        db.open();
        PreparedStatement stmt=db.initStatement(sql);
     ResultSet rs=db.executeQuery();
     while(rs.next()){
     Client c=new Client();
     c.setId(rs.getInt("id"));
     c.setFirstName(rs.getString("first_name"));
     c.setLastName(rs.getString("last_name"));
     c.setEmail(rs.getString("email"));
     
     clientList.add(c);
     }
        db.close();
        return clientList;
    }
    
}
