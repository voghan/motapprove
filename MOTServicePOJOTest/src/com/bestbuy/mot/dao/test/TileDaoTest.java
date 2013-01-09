package com.bestbuy.mot.dao.test;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.bestbuy.mot.dao.TileDao;
import com.bestbuy.mot.dao.TileResponse;

public class TileDaoTest extends TestCase {
	static Logger LOG = Logger.getLogger(TileDaoTest.class);
	
	public void testFindAll() {
		LOG.debug("...inside testFindAll()");
		try {
			TileDao tileDao = new TileDao();
			TileResponse result = tileDao.findAll();
			
			assertNotNull(result);
			assertEquals(5207, result.getTotal_rows());
			assertNotNull(result.getRows());
			assertEquals(5207, result.getRows().size());
		} catch( Exception e) {
			LOG.debug("Test case failed:" + e.getMessage(), e);
			fail(e.getMessage());
		}
	}
	
	public void testFindAllJson() {
		LOG.debug("...inside findAllJson()");
		try {
			TileDao dao = new TileDao();
			String result = dao.findAllJson();
			
			assertNotNull(result);
			LOG.debug(result);
		} catch( Exception e) {
			LOG.debug("Test case failed:" + e.getMessage(), e);
			fail(e.getMessage());
		}
	}
	
	public void testFindVersionJson() {
		LOG.debug("...inside testFindVersionJson()");
		try {
			TileDao dao = new TileDao();
			String versionsId = "111112BA-1-1-COD%20MIDNIGHT%20OPENING";
			String result = dao.findVersionJson(versionsId);
			
			assertNotNull(result);
			LOG.debug(result);
		} catch( Exception e) {
			LOG.debug("Test case failed:" + e.getMessage(), e);
			fail(e.getMessage());
		}
	}

	public void testGetTileJson() {
		LOG.debug("...inside testGetTileJson()");
		try {
			TileDao dao = new TileDao();
			String id = "20fbfb9525b2533bc56e057592d0ee59";
			String result = dao.getJson(id);
			
			assertNotNull(result);
			LOG.debug(result);
		} catch( Exception e) {
			LOG.debug("Test case failed:" + e.getMessage(), e);
			fail(e.getMessage());
		}
	}
	
	public void testSave() {
		LOG.debug("...inside testSave()");
		try {
			TileDao dao = new TileDao();
			String tile = "";
			String result = dao.save(tile);
			
			assertNotNull(result);
			LOG.debug(result);
		} catch( Exception e) {
			LOG.debug("Test case failed:" + e.getMessage(), e);
			fail(e.getMessage());
		}
	}
}
