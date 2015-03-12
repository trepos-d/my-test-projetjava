package com.metier;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="Borne")

public class Borne {
	
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
@Column(name="idBorne")
private int idBorne;

@Column(name="dateMiseEnService")
private String dateMiseEnService;

@Column(name="etat")
private String etat;

@Column(name="laStation")
private Station laStation;

@ManyToOne
@JoinColumn(name="codeTypeCharge")
private TypeCharge typeCharge;


public Borne(int idBorne, String dateMiseEnService,Station laStation, String etat,  TypeCharge typeCharge) {
	super();
	this.idBorne = idBorne;
	this.dateMiseEnService = dateMiseEnService;
	this.etat = etat;
	this.laStation = laStation;
	this.typeCharge = typeCharge;
}
/* Constructeur a vide */
public Borne() {
	super();
}

public void setIdBorne(int idBorne) {
	this.idBorne = idBorne;
}

// constructeur pour nouvelle borne
public Borne(String dateMiseEnService,Station laStation, TypeCharge typeCharge) {
	super();
	this.etat = "ES";
	this.dateMiseEnService = dateMiseEnService;
	this.laStation = laStation;
	this.typeCharge = typeCharge;
}
@Override
public String toString() {
	return "Borne [idBorne =" + idBorne + ", dateMiseEnService="
			+ dateMiseEnService + ", etat=" + etat + ", idStation=" + idStation
			+ ", typeCharge=" + typeCharge.toString() + "]";
}
public Station getLaStation() {
	return laStation;
}
public void setIdStation(Station laStation) {
	this.laStation = laStation;
}
public String getDateMiseEnService() {
	return dateMiseEnService;
}
public void setDateMiseEnService(String dateMiseEnService) {
	this.dateMiseEnService = dateMiseEnService;
}
public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
public TypeCharge getTypeCharge() {
	return typeCharge;
}
public void setTypeCharge(TypeCharge typeCharge) {
	this.typeCharge = typeCharge;
}
public int getIdBorne() {
	return idBorne;
}

}
