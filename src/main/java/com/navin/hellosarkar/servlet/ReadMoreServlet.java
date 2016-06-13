/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navin.hellosarkar.servlet;

import com.navin.hellosarkar.dao.ClientDAO;
import com.navin.hellosarkar.dao.ComplainDAO;
import com.navin.hellosarkar.dao.impl.ClientDAOImpl;
import com.navin.hellosarkar.dao.impl.ComplainDAOImpl;
import com.navin.hellosarkar.entity.Client;
import com.navin.hellosarkar.entity.Complain;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Navin
 */
public class ReadMoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            
              List<Client>clientList=new ArrayList<>();
            ClientDAO clientDAO=new ClientDAOImpl();
            Client client=clientDAO.getById(Integer.parseInt(request.getParameter("id")));
            clientList.add(client);
            request.setAttribute("client", clientList);
            
            List<Complain> compList = new ArrayList<>();
            ComplainDAO compDAO = new ComplainDAOImpl();
            Complain comp = compDAO.getById(Integer.parseInt(request.getParameter("id")));
            compList.add(comp);
            request.setAttribute("complain", compList);
            request.getRequestDispatcher("ReadWhole.jsp").forward(request, response);
        } catch (Exception ex) {
            out.println(ex);
        }

    }
}
