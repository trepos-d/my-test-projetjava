package com.vue;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.persistance.AccesData;

import javax.swing.JLabel;

import java.awt.Font;

import com.metier.*;
import com.modele.ModeleStation;

import javax.swing.JTextField;

public class PanelStation extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private ModeleStation modele;
	private JLabel lblDesStations;
	private Parc unParc;
	private JLabel lblNombreDeStations;
	private JLabel lblNombreDeBornes;
	private JTextField txtTxtnbstation;
	private JTextField txtTxtnbborne;
	/**
	 * Créer le Panel pour afficher la liste des stations
	 * fait appel au modeleStation
	 */
	public PanelStation(Parc p) {

		this.setLayout(null);
		unParc=p;
		modele=new ModeleStation(unParc.getLeParcBorne());
		this.add(getScrollPane());
		this.add(getLblDesStations());
		
		lblNombreDeStations = new JLabel("Nombre de stations ");
		lblNombreDeStations.setBounds(332, 66, 160, 14);
		add(lblNombreDeStations);
		
		lblNombreDeBornes = new JLabel("Nombre de bornes ");
		lblNombreDeBornes.setBounds(332, 91, 156, 14);
		add(lblNombreDeBornes);
		
		txtTxtnbstation = new JTextField();
		txtTxtnbstation.setText(unParc.getNbStation()+"");
		txtTxtnbstation.setBounds(498, 63, 27, 20);
		add(txtTxtnbstation);
		txtTxtnbstation.setColumns(10);
		
		txtTxtnbborne = new JTextField();
		txtTxtnbborne.setText(unParc.getNbBorne()+"");
		txtTxtnbborne.setBounds(498, 88, 27, 20);
		add(txtTxtnbborne);
		txtTxtnbborne.setColumns(10);
	}

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(54, 121, 438, 114);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable(modele);
		}
		return table;
	}

	public JLabel getLblDesStations() {
		if (lblDesStations == null) {
			lblDesStations = new JLabel("Liste des Stations");
			lblDesStations.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblDesStations.setBounds(139, 41, 230, 14);
		}
		return lblDesStations;
	}
}
