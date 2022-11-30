package com.rest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.rest.entity.User;

/**
 * Servlet implementation class JsonController
 */
@WebServlet("/json")
public class JsonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<User> users = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JsonController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setStatus(200);

		User u = new User(1, 20, "Bobby", "b@b.com", "1234");

		String jsonUser = new Gson().toJson(users);

		response.getWriter().write(jsonUser);
		;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int age = Integer.parseInt(request.getParameter("age"));

			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			if (name == null || email == null || password == null) {

				throw new Exception();

			} else {

				User u = new User(id, age, name, email, password);
				users.add(u);
				response.setStatus(200);
			}

		} catch (Exception e) {

			response.setStatus(400);
		}

	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			int id = Integer.parseInt(request.getParameter("id"));

			boolean found = false;

			for (User u : users) {
				if (u.getId() == id) {
					users.remove(u);
					found = true;
				}
			}

			response.setStatus(found ? 200 : 404);

		} catch (Exception e) {
			response.setStatus(400);

		}
	}

}
