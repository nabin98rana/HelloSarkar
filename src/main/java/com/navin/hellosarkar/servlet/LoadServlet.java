/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navin.hellosarkar.servlet;

import com.navin.hellosarkar.dao.ComplainDAO;
import com.navin.hellosarkar.dao.impl.ComplainDAOImpl;
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
public class LoadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            ComplainDAO compDAO = new ComplainDAOImpl();
            List<Complain> compList = new ArrayList<>();
            compList = compDAO.getAll();
            Complain comp = compDAO.getById(Integer.parseInt(request.getParameter("clientId")));
            request.setAttribute("client", comp);
            request.setAttribute("complainList", compList);
            request.getRequestDispatcher("complainList.jsp").forward(request, response);
        } catch (Exception ex) {
            out.println(ex);

        }

    }
}
