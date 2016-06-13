/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navin.hellosarkar.dao.impl;

import com.navin.hellosarkar.dao.ComplainDAO;
import com.navin.hellosarkar.dbutil.DBConnection;
import com.navin.hellosarkar.entity.Complain;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Navin
 */
public class ComplainDAOImpl implements ComplainDAO {
private DBConnection db=new DBConnection();
    @Override
    public int insert(Complain t) throws ClassNotFoundException, SQLException {
        String sql="INSERT INTO tbl_complains(title,description) values(?,?)";
        db.open();
        PreparedStatement stmt=db.initStatement(sql);
        stmt.setString(1, t.getTitle());
        stmt.setString(2, t.getDescription());
        
        int result=db.executeUpdate();
        
        db.close();
        
        return result;
    }

    @Override
    public int update(Complain t) throws ClassNotFoundException, SQLException {
        String sql="UPDATE  tbl_complains SET title=?,description=? WHERE id=?";
        db.open();
        PreparedStatement stmt=db.initStatement(sql);
        stmt.setString(1, t.getTitle());
        stmt.setString(2, t.getDescription());
        stmt.setInt(3, t.getId());
        
        int result=db.executeUpdate();
        
        db.close();
        
        return result;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
          String sql="DELETE  tbl_complains  WHERE id=?";
        db.open();
        PreparedStatement stmt=db.initStatement(sql);
        
        stmt.setInt(1, id);
        
        int result=db.executeUpdate();
        
        db.close();
        
        return result;
    }

    @Override
    public Complain getById(int id) throws ClassNotFoundException, SQLException {
        Complain c=null;  
        String sql="SELECT  *FROM tbl_complains  WHERE id=?";
        db.open();
        PreparedStatement stmt=db.initStatement(sql);
       
        stmt.setInt(1,id);
        
        ResultSet rs=db.executeQuery();
        while(rs.next()){
        c=new Complain();
        c.setId(rs.getInt("id"));
        c.setTitle(rs.getString("title"));
        c.setDescription(rs.getString("description"));
        }
        
        db.close();
        
        return c;
    }

    @Override
    public List<Complain> getAll() throws ClassNotFoundException, SQLException {
        List<Complain>complainList=new ArrayList<>();
        String sql="SELECT *FROM  tbl_complains ";
        db.open();
        PreparedStatement stmt=db.initStatement(sql);
       
       ResultSet rs=stmt.executeQuery();
       while(rs.next()){
       Complain c=new Complain();
       c.setId(rs.getInt("id"));
       c.setTitle(rs.getString("title"));
       c.setDescription(rs.getString("description"));
       
       complainList.add(c);
       }
        
        db.close();
        
        return complainList;
    }
    
}
