package com.ricky.test.dao;

import java.util.List;

import com.ricky.test.model.Server;

public interface ServerDao {

	public int insert(Server server);

	public int update(Server server);

	public int delete(Server server);

	public List<Server> selectAll();

	public int countAll();

	public Server findByServerName (String serverName);
}
