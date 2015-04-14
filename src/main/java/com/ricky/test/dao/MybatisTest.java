package com.ricky.test.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ricky.test.model.Server;

public class MybatisTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String resource = "com/ricky/test/dao/Mybatis-Configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(reader);

			SqlSession session = factory.openSession();
			ServerDao serverDao = session.getMapper(ServerDao.class);

			Server server = new Server();
			server.setServerName("servername1");
			server.setIpAddress("192.168.1.1");

			serverDao.insert(server);
			System.out.println("记录条数：" + serverDao.countAll());

			List<Server> servers = serverDao.selectAll();
			Iterator<Server> iter = servers.iterator();
			while (iter.hasNext()) {
				Server u = iter.next();
				System.out.println("用户名：" + u.getServerName() + " 密码："
						+ u.getIpAddress());
			}

			// user.setComment("comment");
			// userDao.update(user);
			// User u = userDao.findByUserName("hongye");
			// System.out.println(u.getComment());
			//
			// userDao.delete("hongye");
			// System.out.println("记录条数："+userDao.countAll());

			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
