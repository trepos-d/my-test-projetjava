package com.vue;
import java.util.List;
import java.util.ArrayList;

import com.metier.*;
import com.modele.ModeleBorneTypeCharge;
import com.persistance.AccesData;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Cr�er le panel pour choisir le type de charge souhait�
 * fait appel au ModeleBorneTypeCharge pour rechercher et afficher les bornes correspondantes
 */
public class PanelBorneTypeCharge extends JPanel {

	
	private List<TypeCharge> listeTypeCharge=null;
	private ModeleBorneTypeCharge modele=null;
	private JTable table;
	private JComboBox cbxTypeCharge;
	private JScrollPane scrollPane;
	private JLabel lblTypeDeCharge; 
	private Parc unParc;
	public PanelBorneTypeCharge(Parc p) {
		// r�cup�ration des types de charge dans la base de donn�es
		listeTypeCharge = AccesData.getListeTypeCharge();
		// absence de gestionnaire de placement dans le panel
		setLayout(null);
		unParc = p;
		// instanciation et ajout du label 
		lblTypeDeCharge = new JLabel("Type de charge ");
		lblTypeDeCharge.setBounds(72, 78, 143, 14);
		add(lblTypeDeCharge);
		// instanciation JscollPane et Jtable et ajout
		scrollPane = new JScrollPane();
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		scrollPane.setBounds(20, 115, 487, 159);
		scrollPane.setViewportView(table);
		add(scrollPane);
		// instanciation et ajout liste d�roulante
		cbxTypeCharge = new JComboBox();
		cbxTypeCharge.setBounds(251, 75, 125, 20);
		add(cbxTypeCharge);
		// �v�nement sur liste
		cbxTypeCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// instanciation d'un objet Modele
				modele = new ModeleBorneTypeCharge(unParc);
				// transmission au mod�le du type de charge s�lectionn� pour recherche des bornes concern�es
				modele.ChargeListeBorne(listeTypeCharge.get(cbxTypeCharge.getSelectedIndex()).getCodeTypeCharge());
				// affectation du mod�le � la Jtable
				table.setModel(modele);
				// rafraichissement
				table.revalidate();
			}
		});
		// chargement de la liste
		for(TypeCharge t: listeTypeCharge) 	{
			cbxTypeCharge.addItem(t.getLibelleTypeCharge());
		}
		
	}
}
