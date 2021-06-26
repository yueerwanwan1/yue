package com.swufe.javaee.jsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hobbyFind")
public class HobbyServlet extends HttpServlet {
	private Map<String, String[]> userHobby;

	@Override
	public void init() {
		userHobby = new HashMap<String, String[]>();
		String[] bob = { "skiing" };
		userHobby.put("Bob", bob);
		String[] Jim = { "skiing" };
		userHobby.put("Jim", Jim);
		String[] James = { "knitting" };
		userHobby.put("James", James);
		String[] Tom = { "knitting" };
		userHobby.put("Tom", Tom);
		String[] Fei = { "skiing" };
		userHobby.put("Fei", Fei);
		String[] Jone = { "scuba" };
		userHobby.put("Jone", Jone);
		String[] Fred = { "dating" };
		userHobby.put("Fred", Fred);
		String[] Pradeep = { "dating" };
		userHobby.put("Pradeep", Pradeep);
		String[] Philippe = { "dating" };
		userHobby.put("Philippe", Philippe);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hobby = request.getParameter("hobby");
		List<String> names = new ArrayList<>();
		userHobby.forEach((k, v) -> {
			for (int i = 0; i < v.length; i++) {

				if (v[i].equals(hobby)) {
					names.add(k);
				}
			}
		});
		request.setAttribute("names", names);
		request.setAttribute("hobby", hobby);
		// Two JSPs have different UI styles.
		request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
		// request.getRequestDispatcher("hobbyResult2.jsp").forward(request, response);
	}

}
