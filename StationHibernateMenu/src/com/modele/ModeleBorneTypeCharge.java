package com.modele;
import java.util.List;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.metier.Parc;
import com.metier.Borne;
import com.metier.Station;
import com.metier.TypeCharge;
public class ModeleBorneTypeCharge extends AbstractTableModel {
	private final String[] entetes = { "idBorne", "date mise en service", "libelle emplacement", "puissance"};
	private List<Borne> listeTypeChargeBorne = null;

	public ModeleBorneTypeCharge(TypeCharge t) {

	listeTypeChargeBorne = t.getLesBornes();

	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public int getRowCount() {
		return listeTypeChargeBorne.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			// idBorne
			return listeTypeChargeBorne.get(rowIndex).getIdBorne();
		case 1:
			// Date de mise en service
			return listeTypeChargeBorne.get(rowIndex).getDateMiseEnService();
		case 2:
			// on fait appel à une nouvelle méthode de Parc qui récupère le libelleEmplacement de la station
			// on évite ainsi de refaire appel à AccesData
			// autrement on aurais pu passer par 
			//return AccesData.getStation(listeTypeChargeBorne.get(rowIndex).getIdStation()).getLibelleEmplacement();
			return unParc.getLibelleStation(listeTypeChargeBorne.get(rowIndex).getIdStation());
		case 3:
			// puissance
			return listeTypeChargeBorne.get(rowIndex).getTypeCharge().getPuissanceTypeCharge();
		default:
			throw new IllegalArgumentException();
	}
	}
}

