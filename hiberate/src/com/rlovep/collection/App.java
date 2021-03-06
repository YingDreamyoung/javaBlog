package com.rlovep.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class App {
	private static SessionFactory sf=null;
	static{
		Configuration config=new Configuration().configure().addClass(CollUser.class);
		//创建serviceRegistry  代替buildSessionFactory()方法
   		ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
   		// 创建session的工厂对象
   		sf = config.buildSessionFactory(serviceRegistry);
	}
	//测试set
	@Test
	public void testSet(){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//创建对象
		CollUser collUser=new CollUser();
		collUser.setUserName("peace");
		Set<String> adress=new HashSet<>();
		adress.add("五山");
		adress.add("三号楼");
		collUser.setAddress(adress);
		//保存对象
		session.save(collUser);
		tx.commit();
		//获取对象
		tx=session.beginTransaction();
		CollUser user = (CollUser) session.get(CollUser.class, 1);
		System.out.println(user.getAddress());
		tx.commit();
		session.close();
	}
	//测试list
		@Test
		public void testList(){
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			//创建对象
			CollUser collUser=new CollUser();
			collUser.setUserName("peace1");
			List<String> adress=new ArrayList<>();
			adress.add("五山");
			adress.add("三号楼");
			collUser.setAddressList(adress);
			//保存对象
			session.save(collUser);
			tx.commit();
			//获取对象
			tx=session.beginTransaction();
			CollUser user = (CollUser) session.get(CollUser.class, 2);
			System.out.println(user.getAddressList());
			tx.commit();
			session.close();
		}
		//测试map
	@Test
	public void testMap() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		// 创建对象
		CollUser collUser = new CollUser();
		collUser.setUserName("peace2");
		Map<String, String>map=new HashMap<>();
		map.put("三号楼", "五山");
		map.put("五山", "西六");
		collUser.setAddressMap(map);
		// 保存对象
		session.save(collUser);
		tx.commit();
		// 获取对象
		tx = session.beginTransaction();
		CollUser user = (CollUser) session.get(CollUser.class, 3);
		System.out.println(user.getAddressMap());
		tx.commit();
		session.close();
	}
}
