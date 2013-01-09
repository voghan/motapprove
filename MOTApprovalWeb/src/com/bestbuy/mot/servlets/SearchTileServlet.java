package com.bestbuy.mot.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bestbuy.mot.dao.TileDao;

public class SearchTileServlet extends AbstractBaseServlet {

	private static final long serialVersionUID = -1343171300233565431L;
	static Logger LOG = Logger.getLogger(SearchTileServlet.class);

	
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LOG.debug("... inside handleRequest");
		LOG.debug("Request handled by SearchTileServlet");
		
		
		StringBuffer url = req.getRequestURL();
		LOG.debug(url.toString());
		
		try {
			
			String id = req.getParameter("id");
			String versionsId = req.getParameter("versionsId");
			
			if ( id != null ) {
				findSingleTileVersion(resp, id);
			} else if ( versionsId != null ) {
				findTileVersion(resp, versionsId);
			} else {
				findAllTiles(resp);
			}
			
		} catch (Exception e) {
			
		}
		
		
	}
	
	private void findSingleTileVersion(HttpServletResponse resp, String id) {
		TileDao tileDao = new TileDao();
		String json = tileDao.getJson(id);
		
		writeOut(resp, json);
	}
	
	private void findTileVersion(HttpServletResponse resp, String versionsId) {
		TileDao tileDao = new TileDao();
		String json = tileDao.findVersionJson(versionsId);
		
		writeOut(resp, json);
	}
	
	private void findAllTiles(HttpServletResponse resp) {
		TileDao tileDao = new TileDao();
		String json = tileDao.findAllJson();
		
		writeOut(resp, json);
	}

}
