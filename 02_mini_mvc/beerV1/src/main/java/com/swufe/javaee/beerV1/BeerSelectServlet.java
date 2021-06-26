package com.swufe.javaee.beerV1;

import com.swufe.javaee.beerV1.model.Beer;
import com.swufe.javaee.beerV1.model.BeerExpert;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name="BBeer",value = "/SelectBeer.do")
public class BeerSelectServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("color");
        BeerExpert bbeer = new BeerExpert();

        //List<String> result = expert.getBrands(c);
        List result2 = bbeer.getBeers(c);
        request.setAttribute("styles", result2);
        RequestDispatcher view = request.getRequestDispatcher("/result.jsp");
        view.forward(request, response);
    }

}
