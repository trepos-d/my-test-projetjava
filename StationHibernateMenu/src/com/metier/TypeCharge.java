package com.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="TypeCharge")
public class TypeCharge {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codeTypeCharge")
	private int codeTypeCharge;
	
	@Column(name="libelleTypeCharge")
	private String libelleTypeCharge;
	
	@Column(name="puissanceTypeCharge")
	private int puissanceTypeCharge;
	
	@OneToMany
	@JoinColumn(name="codeTypeCharge")
	private List<Borne> lesBornes;
	
	/* Constructeur a vide */
	public TypeCharge() {
		super();
	}

	public void setCodeTypeCharge(int codeTypeCharge) {
		this.codeTypeCharge = codeTypeCharge;
	}

	public TypeCharge(int codeTypeCharge, String libelleTypeCharge,
			int puissanceTypeCharge) {
		super();
		this.codeTypeCharge = codeTypeCharge;
		this.libelleTypeCharge = libelleTypeCharge;
		this.puissanceTypeCharge = puissanceTypeCharge;
		this.lesBornes = new ArrayList<Borne>();
	}
	
	public TypeCharge(String libelleTypeCharge, int puissanceTypeCharge) {
		super();
		this.libelleTypeCharge = libelleTypeCharge;
		this.puissanceTypeCharge = puissanceTypeCharge;
	}

	public String getLibelleTypeCharge() {
		return libelleTypeCharge;
	}
	public void setLibelleTypeCharge(String libelleTypeCharge) {
		this.libelleTypeCharge = libelleTypeCharge;
	}
	public int getPuissanceTypeCharge() {
		return puissanceTypeCharge;
	}
	public void setPuissanceTypeCharge(int puissanceTypeCharge) {
		this.puissanceTypeCharge = puissanceTypeCharge;
	}
	public int getCodeTypeCharge() {
		return codeTypeCharge;
	}
	
	public List<Borne> getLesBornes() {
		return lesBornes;
	}
	public void setLesBornes(List<Borne> lesBornes) {
		this.lesBornes = lesBornes;
	}
	
	@Override
	public String toString() {
		return "TypeCharge [codeTypeCharge=" + codeTypeCharge
				+ ", libelleTypeCharge=" + libelleTypeCharge
				+ ", puissanceTypeCharge=" + puissanceTypeCharge + "]";
	}
}
