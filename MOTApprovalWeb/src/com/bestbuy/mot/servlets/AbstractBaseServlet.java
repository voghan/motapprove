package com.bestbuy.mot.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public abstract class AbstractBaseServlet extends HttpServlet {

	private static final long serialVersionUID = 5253599902930933470L;
	static Logger LOG = Logger.getLogger(AbstractBaseServlet.class);

	abstract void handleRequest(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LOG.debug("... inside doGet");
		handleRequest(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LOG.debug("... inside doPost");
		handleRequest(req, resp);
	}
	
	public void writeOut(HttpServletResponse resp, String message) {
		try {
			PrintWriter out = resp.getWriter();
			out.print(message);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
