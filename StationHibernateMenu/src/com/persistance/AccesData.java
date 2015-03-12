package com.persistance;
import java.util.List;

import com.metier.*;
import com.util.HibernateSession;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class AccesData {
	
	public static Session session = HibernateSession.getSession(); 
	// accesseurs sur listes d'objets
	
	
	public static List<TypeCharge> getListeTypeCharge() 	{
		
		return session.createQuery("from TypeCharge").list();
		
	}
	public static List<Station> getListeStation() 	{
		
		return session.createQuery("from Station").list();
		
	}
	public static List<Borne> getListeBorne() 	{
		
		return session.createQuery("from Borne").list();
		
	}
	public static List<Borne> getListeBorneStation(int idStation) 	{
	
		return (List<Borne>) session.createQuery("from Borne where idStation="+idStation).list();
		
	}
	public static TypeCharge getTypeCharge(int idType) 	{
		
		return (TypeCharge) session.get(TypeCharge.class, idType);
		
	}
	public static Station getStation(int idStation) 	{
		
		return (Station) session.get(Station.class, idStation);
		
	}
	public static Borne getBorne(int idBorne) 	{
		
		return (Borne) session.get(Borne.class, idBorne);	
		
	}
	public static boolean addStation(Station s) 	{
		
		Transaction trans = session.beginTransaction();
		session.persist(s);
		trans.commit();
	
		return true;
	}
	public static boolean deleteStation(Station s) 	{
		
		Transaction trans = session.beginTransaction();
		session.delete(s);;
		trans.commit();
		
		return true;
		
	}
	public static boolean updateStation(Station s) 	{
		
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(s);
		trans.commit();
		
		return true;
		
	}
	public static boolean addBorne(Borne b) 	{
		
		Transaction trans = session.beginTransaction();
		session.persist(b);
		trans.commit();
	
		return true;
	}
	public static boolean deleteBorne(Borne b) 	{
		
		Transaction trans = session.beginTransaction();
		session.delete(b);;
		trans.commit();
		
		return true;
		
	}
	public static boolean updateBorne(Borne b) 	{
		
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(b);
		trans.commit();
		
		return true;
		
	}
	public static boolean updateTypeCharge(TypeCharge t)
	{
		
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(t);
		trans.commit();
		
		return true;
		
	}
	public static boolean deleteTypeCharge(TypeCharge t) 	{
		
		Transaction trans = session.beginTransaction();
		session.delete(t);;
		trans.commit();
		
		return true;
		
	}
	public static boolean addTypeCharge(TypeCharge t) 	{
		
		Transaction trans = session.beginTransaction();
		session.persist(t);
		trans.commit();
	
		return true;
		
	}


}
