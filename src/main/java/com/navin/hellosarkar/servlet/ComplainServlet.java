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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Navin
 */
public class ComplainServlet extends ControllerServlet {

    ComplainDAO compDAO = new ComplainDAOImpl();
    ClientDAO clientDAO = new ClientDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
           request.setAttribute("complain", compDAO.getAll());

        } catch (Exception e) {
            out.println(e.getMessage());
        }
       RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
       dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Client c = new Client();
            Complain comp = new Complain();
            ComplainDAO compDAO = new ComplainDAOImpl();
            ClientDAO clientDAO = new ClientDAOImpl();

            c.setFirstName(request.getParameter("first_name"));

            c.setLastName(request.getParameter("last_name"));
            c.setEmail(request.getParameter("email"));

            int cresult = clientDAO.insert(c);

            int clientid = 0;
            for (Client client : clientDAO.getAll()) {
                clientid = client.getId();
                out.println(clientid);
            }

            comp.setTitle(request.getParameter("title"));
            comp.setDescription(request.getParameter("description"));
            comp.setId(clientid);

            int compresult = compDAO.insert(comp);

            request.getRequestDispatcher("complainList.jsp").forward(request, response);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            out.println(ex);
        }

    }

}
