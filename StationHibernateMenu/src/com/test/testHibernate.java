package com.test;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.transaction.*;

import com.metier.*;
import com.util.HibernateSession;

public class testHibernate {

	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session s = HibernateSession.getSession();
		List<TypeCharge> liste = s.createQuery("from TypeCharge").list();
		for(TypeCharge t :liste)
		{
			System.out.println(t.toString());
		}
		TypeCharge tp= (TypeCharge) s.get(TypeCharge.class, 2);
		System.out.println(tp.toString());
		}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session s = HibernateSession.getSession();
		List<Borne> liste = s.createQuery("from Borne").list();
		for(Borne b :liste)
		{
			System.out.println(b.toString());
		}
		Borne bo= (Borne) s.get(Borne.class, 2);
		System.out.println(bo.toString());
		}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session s = HibernateSession.getSession();
		List<Station> liste = s.createQuery("from Station").list();
		for(Station st :liste)
		{
			System.out.println(st.toString());
		}
		Station sta= (Station) s.get(Station.class, 2);
		System.out.println(sta.toString());
		}
	*/
	
	public static void main(String[] args) {
		Session session = HibernateSession.getSession();
	}
	
	
	
	
	
	}


