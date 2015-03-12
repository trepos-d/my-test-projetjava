package com.test;
import java.util.List;
import java.util.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Borne;
import com.metier.Parc;
import com.metier.Station;
import com.metier.TypeCharge;

public class ParcTest {
	
	private TypeCharge t1, t2, t3;
	private Borne b1, b2, b3, b4, b5;
	private List<Borne> listeBorne1;
	private List<Borne> listeBorne2;
	private Station s1, s2, s3;
	private List<Station> listeStation1;
	private List<Station> listeStation2;
	private Parc p, p0;
	


	@Before
	public void setUp() throws Exception {
		t1=new TypeCharge(1, "normale", 3);
		t2=new TypeCharge(2, "semi-rapide",24);
		t3=new TypeCharge(3, "semi-rapide",50);
		b1=new Borne(10, "25/09/2014",100,"ES", t1);
		b2=new Borne(20, "25/09/2014",100,"ES", t2);
		b3=new Borne(30, "25/09/2014",200, "ES",t1);
		b4=new Borne(40, "25/09/2014",200,"ES", t1);
		b5=new Borne(50, "25/09/2014",200,"ES", t2);
		listeBorne1=new ArrayList<Borne>();
		listeBorne2=new ArrayList<Borne>();
		listeBorne1.add(b1);
		listeBorne1.add(b2);
		listeBorne2.add(b3);
		listeBorne2.add(b4);
		listeBorne2.add(b5);
		s1=new Station(100, "gare MontParnasse");
		s1.setLesBornes(listeBorne1);
		s2=new Station(200, "gare de l'Est");
		s2.setLesBornes(listeBorne2);
		s3=new Station(300, "gare de du Nord");
		p=new Parc();
		listeStation1= new ArrayList<Station>();
		listeStation2= new ArrayList<Station>();
		listeStation1.add(s1);
		listeStation1.add(s2);
		listeStation2.add(s3);
		p.setLeParcBorne(listeStation1);
		p0=new Parc();
		
	}

	@After
	public void tearDown() throws Exception {
		t1=null;
		t2=null;
		t3=null;
		b1=null;
		b2=null;
		b3=null;
		b4=null;
		b5=null;
		listeBorne1=null;
		listeBorne2=null;
		listeStation1=null;
		listeStation2=null;
		s1=null;
		s2=null;
		s3=null;
		p=null;
		p0=null;
	}

	@Test
	public void testParc() {
		assertNotNull(p);
		assertNotNull(p0);
	}

	@Test
	public void testGetLeParcBorne() {
		assertEquals(listeStation1, p.getLeParcBorne());
		assertEquals(0, p0.getLeParcBorne().size());
		
	}

	@Test
	public void testSetLeParcBorne() {
		p.setLeParcBorne(listeStation2);
		assertEquals(listeStation2, p.getLeParcBorne());
		
	}

	@Test
	public void testAjouterStation() {
		p.ajouterStation(s3);
		assertEquals(3, p.getNbStation());
		assertEquals(s3, p.getLeParcBorne().get(2));
		assertEquals(s3.getIdStation(), p.getLeParcBorne().get(2).getIdStation());
	}

	@Test
	public void testGetNbStation() {
	assertEquals(2, p.getNbStation());
	}

	@Test
	public void testGetNbBorne() {
		assertEquals(5,p.getNbBorne());
	}

	@Test
	public void testGetLaStation() {
		assertSame(listeBorne1, p.getLaStation(100));
		assertEquals(listeBorne2, p.getLaStation(200));
		assertEquals(0, p.getLaStation(300).size());
	}

	@Test
	public void testGetStationTypeCharge() {
		assertEquals(s1, p.getStationTypeCharge(1).get(0));
		assertEquals(s2, p.getStationTypeCharge(1).get(1));
		assertEquals(0, p.getStationTypeCharge(3).size());
	}

}
