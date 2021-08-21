package GUIConfiguracion;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import DBManager.DBManager;
import DBManager.InsertData;
import DBManager.SelectData;
import DataType.DatosXML;

import java.awt.Dimension;
import java.awt.Cursor;

public class PanelDatosXML extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldIDVersionTBAI;
	private JTextField textFieldRazonSocial;
	private JTextField textFieldNIF;
	private JLabel txtNIF;
	private JComboBox<String> BoxTipoFactura;
	private JLabel lblNewLabel_1;
	private JLabel txtTipoDeFactura;
	private JComboBox<String> BoxCausaExencion;
	private JComboBox<String> BoxTipoNoExenta;
	private JComboBox<String> BoxClaveRegimen;
	private JComboBox<String> BoxOperacionRecargo;
	private JLabel txtClaveRegimen;
	private JLabel txtCausaExencion;
	private JLabel txtTipoNoExenta;
	private JLabel txtOperacionRecargo;
	private JComboBox<String> BoxCausaNoSujecion;
	private JLabel txtCausaNoSujecion;
	
	private HashMap<String, String> L6;
	private HashMap<String, String> L9;
	private HashMap<String, String> L10;
	private HashMap<String, String> L11;
	private HashMap<String, String> L12;
	private HashMap<String, String> L13;
	

	
	public PanelDatosXML(boolean estadoEdicion) {
			
		setBackground(new Color(255, 204, 51));
		setVisible(false);
		
		GridBagLayout gbl_PanelDatosXML = new GridBagLayout();
		gbl_PanelDatosXML.columnWidths = new int[]{174, 357, 0, 0, 0};
		gbl_PanelDatosXML.rowHeights = new int[]{40, 26, 35, 0, 0, 0, 0, 0, 35, 27, 0, 27, 19, 0, 0, 0, 0, 0, 0};
		gbl_PanelDatosXML.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_PanelDatosXML.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_PanelDatosXML);
		
		JLabel txtIDVersionTBAI = new JLabel("IDVersionTBAI: ");
		txtIDVersionTBAI.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtIDVersionTBAI = new GridBagConstraints();
		gbc_txtIDVersionTBAI.insets = new Insets(0, 0, 5, 5);
		gbc_txtIDVersionTBAI.anchor = GridBagConstraints.EAST;
		gbc_txtIDVersionTBAI.gridx = 0;
		gbc_txtIDVersionTBAI.gridy = 1;
		add(txtIDVersionTBAI,gbc_txtIDVersionTBAI);
		
		textFieldIDVersionTBAI = new JTextField();
		textFieldIDVersionTBAI.setEditable(estadoEdicion);
		textFieldIDVersionTBAI.setEnabled(estadoEdicion);
		textFieldIDVersionTBAI.setFocusTraversalPolicyProvider(true);
		GridBagConstraints gbc_textFieldIDVersionTBAI = new GridBagConstraints();
		gbc_textFieldIDVersionTBAI.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIDVersionTBAI.fill = GridBagConstraints.BOTH;
		gbc_textFieldIDVersionTBAI.gridx = 1;
		gbc_textFieldIDVersionTBAI.gridy = 1;
		add(textFieldIDVersionTBAI, gbc_textFieldIDVersionTBAI);
		textFieldIDVersionTBAI.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Persona o Entidad Desarrolladora");
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel txtRazonSocial = new JLabel("Razon Social: ");
		txtRazonSocial.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtRazonSocial = new GridBagConstraints();
		gbc_txtRazonSocial.insets = new Insets(0, 0, 5, 5);
		gbc_txtRazonSocial.anchor = GridBagConstraints.EAST;
		gbc_txtRazonSocial.gridx = 0;
		gbc_txtRazonSocial.gridy = 3;
		add(txtRazonSocial, gbc_txtRazonSocial);
		
		textFieldRazonSocial= new JTextField();
		textFieldRazonSocial.setEditable(estadoEdicion);
		textFieldRazonSocial.setEnabled(estadoEdicion);
		GridBagConstraints gbc_textFieldRazonSocial = new GridBagConstraints();
		gbc_textFieldRazonSocial.insets = new Insets(0, 0, 5, 5);
	    gbc_textFieldRazonSocial.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRazonSocial.gridx = 1;
		gbc_textFieldRazonSocial.gridy = 3;
		add(textFieldRazonSocial,gbc_textFieldRazonSocial);
		textFieldRazonSocial.setColumns(10);
		
		txtNIF = new JLabel("NIF: ");
		txtNIF.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		GridBagConstraints gbc_txtNIF = new GridBagConstraints();
		gbc_txtNIF.insets = new Insets(0, 0, 5, 5);
		gbc_txtNIF.anchor = GridBagConstraints.EAST;
		gbc_txtNIF.gridx = 0;
		gbc_txtNIF.gridy = 5;
		add(txtNIF, gbc_txtNIF);
		
		textFieldNIF = new JTextField();
		textFieldNIF.setEnabled(estadoEdicion);
		textFieldNIF.setEditable(estadoEdicion);
		GridBagConstraints gbc_textFieldNIF = new GridBagConstraints();
		gbc_textFieldNIF.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNIF.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNIF.gridx = 1;
		gbc_textFieldNIF.gridy = 5;
		add(textFieldNIF, gbc_textFieldNIF);
		textFieldNIF.setColumns(10);
		
		txtTipoDeFactura = new JLabel("Tipo de Factura: ");
		txtTipoDeFactura.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		GridBagConstraints gbc_txtTipoDeFactura = new GridBagConstraints();
		gbc_txtTipoDeFactura.insets = new Insets(0, 0, 5, 5);
		gbc_txtTipoDeFactura.anchor = GridBagConstraints.EAST;
		gbc_txtTipoDeFactura.gridx = 0;
		gbc_txtTipoDeFactura.gridy = 7;
		add(txtTipoDeFactura, gbc_txtTipoDeFactura);
		
		BoxTipoFactura = new JComboBox<String>();
		BoxTipoFactura.setEnabled(estadoEdicion);
		//Cargar datos de Tipo de Factura -L6-
				cargarDatos(6);
		GridBagConstraints gbc_BoxTipoFactura = new GridBagConstraints();
		gbc_BoxTipoFactura.insets = new Insets(0, 0, 5, 5);
		gbc_BoxTipoFactura.fill = GridBagConstraints.HORIZONTAL;
		gbc_BoxTipoFactura.gridx = 1;
		gbc_BoxTipoFactura.gridy = 7;
		add(BoxTipoFactura, gbc_BoxTipoFactura);
		
		txtClaveRegimen = new JLabel("Clave de r\u00E9gimen especial del IVA y operaciones con transparencia tributaria");
		GridBagConstraints gbc_txtClaveRegimen = new GridBagConstraints();
		gbc_txtClaveRegimen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtClaveRegimen.insets = new Insets(0, 0, 5, 5);
		gbc_txtClaveRegimen.gridx = 1;
		gbc_txtClaveRegimen.gridy = 8;
		add(txtClaveRegimen, gbc_txtClaveRegimen);
		
		
		BoxClaveRegimen = new JComboBox <String>();
		BoxClaveRegimen.setEnabled(estadoEdicion);
		//Cargar datos de Clave de Regimen -L9-
		cargarDatos(9);
		BoxClaveRegimen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BoxClaveRegimen.setSize(new Dimension(370, 35));

		GridBagConstraints gbc_BoxClaveRegimen = new GridBagConstraints();
		gbc_BoxClaveRegimen.insets = new Insets(0, 0, 5, 5);
		gbc_BoxClaveRegimen.fill = GridBagConstraints.BOTH;
		gbc_BoxClaveRegimen.gridx = 1;
		gbc_BoxClaveRegimen.gridy = 9;
		add(BoxClaveRegimen, gbc_BoxClaveRegimen);
		
		txtCausaExencion = new JLabel("Causa de exenci\u00F3n de operaciones sujetas y exentas");
		GridBagConstraints gbc_txtCausaExencion = new GridBagConstraints();
		gbc_txtCausaExencion.insets = new Insets(0, 0, 5, 5);
		gbc_txtCausaExencion.gridx = 1;
		gbc_txtCausaExencion.gridy = 10;
		add(txtCausaExencion, gbc_txtCausaExencion);
		
		BoxCausaExencion = new JComboBox<String>();
		BoxCausaExencion.setEnabled(estadoEdicion);
		//Cargar datos de Causa de Exencion -L10-
				cargarDatos(10);
		GridBagConstraints gbc_BoxCausaExencion = new GridBagConstraints();
		gbc_BoxCausaExencion.insets = new Insets(0, 0, 5, 5);
		gbc_BoxCausaExencion.fill = GridBagConstraints.HORIZONTAL;
		gbc_BoxCausaExencion.gridx = 1;
		gbc_BoxCausaExencion.gridy = 11;
		add(BoxCausaExencion, gbc_BoxCausaExencion);
		
		txtTipoNoExenta = new JLabel("Tipo no Exenta: ");
		GridBagConstraints gbc_txtTipoNoExenta = new GridBagConstraints();
		gbc_txtTipoNoExenta.insets = new Insets(0, 0, 5, 5);
		gbc_txtTipoNoExenta.anchor = GridBagConstraints.EAST;
		gbc_txtTipoNoExenta.gridx = 0;
		gbc_txtTipoNoExenta.gridy = 13;
		add(txtTipoNoExenta, gbc_txtTipoNoExenta);
		
		BoxTipoNoExenta = new JComboBox<String>();
		BoxTipoNoExenta.setEnabled(estadoEdicion);
		//Cargar datos de Tipo No Exento -L11-
				cargarDatos(11);
				
		GridBagConstraints gbc_BoxTipoNoExenta = new GridBagConstraints();
		gbc_BoxTipoNoExenta.insets = new Insets(0, 0, 5, 5);
		gbc_BoxTipoNoExenta.fill = GridBagConstraints.HORIZONTAL;
		gbc_BoxTipoNoExenta.gridx = 1;
		gbc_BoxTipoNoExenta.gridy = 13;
		add(BoxTipoNoExenta, gbc_BoxTipoNoExenta);
		
		txtOperacionRecargo = new JLabel("Operaci\u00F3n en recargo de equivalencia o r\u00E9gimen simplificado");
		GridBagConstraints gbc_txtOperacionRecargo = new GridBagConstraints();
		gbc_txtOperacionRecargo.insets = new Insets(0, 0, 5, 5);
		gbc_txtOperacionRecargo.gridx = 1;
		gbc_txtOperacionRecargo.gridy = 14;
		add(txtOperacionRecargo, gbc_txtOperacionRecargo);
		
		BoxOperacionRecargo = new JComboBox<String>();
		BoxOperacionRecargo.setEnabled(estadoEdicion);
		//Cargar datos de Operacion Recargo -L12-
				cargarDatos(12);
				
		GridBagConstraints gbc_BoxOperacionRecargo = new GridBagConstraints();
		gbc_BoxOperacionRecargo.insets = new Insets(0, 0, 5, 5);
		gbc_BoxOperacionRecargo.fill = GridBagConstraints.HORIZONTAL;
		gbc_BoxOperacionRecargo.gridx = 1;
		gbc_BoxOperacionRecargo.gridy = 15;
		add(BoxOperacionRecargo, gbc_BoxOperacionRecargo);
		
		txtCausaNoSujecion = new JLabel("Causa no Sujeci\u00F3n: ");
		GridBagConstraints gbc_txtCausaNoSujecion = new GridBagConstraints();
		gbc_txtCausaNoSujecion.insets = new Insets(0, 0, 0, 5);
		gbc_txtCausaNoSujecion.anchor = GridBagConstraints.EAST;
		gbc_txtCausaNoSujecion.gridx = 0;
		gbc_txtCausaNoSujecion.gridy = 17;
		add(txtCausaNoSujecion, gbc_txtCausaNoSujecion);
		
		BoxCausaNoSujecion = new JComboBox<String>();
		BoxCausaNoSujecion.setEnabled(estadoEdicion);
		//Cargar datos de Causa No Sujeta -L13-
				cargarDatos(13);
		GridBagConstraints gbc_BoxCausaNoSujecion = new GridBagConstraints();
		gbc_BoxCausaNoSujecion.insets = new Insets(0, 0, 0, 5);
		gbc_BoxCausaNoSujecion.fill = GridBagConstraints.HORIZONTAL;
		gbc_BoxCausaNoSujecion.gridx = 1;
		gbc_BoxCausaNoSujecion.gridy = 17;
		add(BoxCausaNoSujecion, gbc_BoxCausaNoSujecion);
		
		cargarDatosSeleccionados();
	}
	 
	public void cargarDatosSeleccionados() {
		DBManager manager = new DBManager();
		manager.connect();
		Connection connection =manager.connection;
		SelectData selection = new SelectData();
		
		DatosXML datos = selection.selectDatosXML(connection);
		
		if(datos != null) {
			textFieldIDVersionTBAI.setText(datos.getIDVersionTBAI());
			textFieldNIF.setText(datos.getNIF());
			textFieldRazonSocial.setText(datos.getRazonSocial());
			
			//se selecciona la opcion guarda por ultima vez en el campo L6
			for (int i = 0; i < BoxTipoFactura.getItemCount(); i++) {
				String texto = BoxTipoFactura.getItemAt(i).toString();
				texto = texto.substring(0, 2);
				
				if(texto.equals(datos.getL6())) {
					BoxTipoFactura.setSelectedIndex(i);
				}
			}
			
			//se selecciona la opcion guarda por ultima vez en el campo L9
			for (int i = 0; i < BoxClaveRegimen.getItemCount(); i++) {
				String texto = BoxClaveRegimen.getItemAt(i).toString();
				texto = texto.substring(0, 2);
				
				if(texto.equals(datos.getL6())) {
					BoxClaveRegimen.setSelectedIndex(i);
				}
			}
			
			//se selecciona la opcion guarda por ultima vez en el campo L10
			for (int i = 0; i < BoxCausaExencion.getItemCount(); i++) {
				String texto = BoxCausaExencion.getItemAt(i).toString();
				texto = texto.substring(0, 2);
				
				if(texto.equals(datos.getL6())) {
					BoxCausaExencion.setSelectedIndex(i);
				}
			}
			
			//se selecciona la opcion guarda por ultima vez en el campo L11
			for (int i = 0; i < BoxTipoNoExenta.getItemCount(); i++) {
				String texto = BoxTipoNoExenta.getItemAt(i).toString();
				texto = texto.substring(0, 2);
				
				if(texto.equals(datos.getL6())) {
					BoxTipoNoExenta.setSelectedIndex(i);
				}
			}
			
			//se selecciona la opcion guarda por ultima vez en el campo L12
			for (int i = 0; i < BoxOperacionRecargo.getItemCount(); i++) {
				String texto = BoxOperacionRecargo.getItemAt(i).toString();
				texto = texto.substring(0, 2);
				
				if(texto.equals(datos.getL6())) {
					BoxOperacionRecargo.setSelectedIndex(i);
				}
			}
			
			//se selecciona la opcion guarda por ultima vez en el campo L12
			for (int i = 0; i < BoxCausaNoSujecion.getItemCount(); i++) {
				String texto = BoxCausaNoSujecion.getItemAt(i).toString();
				texto = texto.substring(0, 2);
				
				if(texto.equals(datos.getL6())) {
					BoxCausaNoSujecion.setSelectedIndex(i);
				}
			}
		}	
		manager.disconnect();
	}
	
	public void cargarDatos(int tipo) {
		DBManager manager = new DBManager();
		manager.connect();
		Connection connection =manager.connection;
		SelectData selection = new SelectData();
			
		if(tipo == 6) {
			L6 = selection.selectL6(connection);
			for(int i = 0;i <L6.size();i++) {
				Object firstKey = L6.keySet().toArray()[i];
				Object valueForFirstKey = L6.get(firstKey);
				BoxTipoFactura.addItem(new String(firstKey+" - "+valueForFirstKey));
			}
		}else if(tipo == 9) {
			L9 = selection.selectL9(connection);
			for(int i = 0;i <L9.size();i++) {
				Object firstKey = L9.keySet().toArray()[i];
				Object valueForFirstKey = L9.get(firstKey);
				BoxClaveRegimen.addItem("<html><body style='width: 370px; text-align: justify;margin-left: 20px;text-indent: -20px;'>" + new String(firstKey+" - "+valueForFirstKey));
			}
		}else if (tipo == 10) {
			L10 = selection.selectL10(connection);
			for(int i = 0;i < L10.size();i++) {
				Object firstKey = L10.keySet().toArray()[i];
				Object valueForFirstKey = L10.get(firstKey);
				BoxCausaExencion.addItem(new String(firstKey+" - "+valueForFirstKey));
			}
		}else if (tipo == 11) {
			L11 = selection.selectL11(connection);
			for(int i = 0;i < L11.size();i++) {
				Object firstKey = L11.keySet().toArray()[i];
				Object valueForFirstKey = L11.get(firstKey);
				BoxTipoNoExenta.addItem(new String(firstKey+" - "+valueForFirstKey));
			}
		}else if (tipo == 12) {
			L12 = selection.selectL12(connection);
			for(int i = 0;i < L12.size();i++) {
				Object firstKey = L12.keySet().toArray()[i];
				Object valueForFirstKey = L12.get(firstKey);
				BoxOperacionRecargo.addItem(new String(firstKey+" - "+valueForFirstKey));
			}
		}else if (tipo == 13) {
			L13 = selection.selectL13(connection);
			for(int i = 0;i < L13.size();i++) {
				Object firstKey = L13.keySet().toArray()[i];
				Object valueForFirstKey = L13.get(firstKey);
				BoxCausaNoSujecion.addItem(new String(firstKey+" - "+valueForFirstKey));
			}
		}
		manager.disconnect();
	}

	public void guardarDatos() {
		DBManager manager = new DBManager();
		manager.connect();
		Connection connection = manager.connection;
		InsertData insert  = new InsertData();
		
		String IDVersionTBAI = textFieldIDVersionTBAI.getText();
		String NIF = textFieldNIF.getText();
		String RazonSocial = textFieldRazonSocial.getText();
		
		Object keyL6 = L6.keySet().toArray()[BoxTipoFactura.getSelectedIndex()];
		String L6 = (String) keyL6;
		
		Object keyL9 = L9.keySet().toArray()[BoxClaveRegimen.getSelectedIndex()];
		String L9 = (String) keyL9;
		
		Object keyL10 = L10.keySet().toArray()[BoxCausaExencion.getSelectedIndex()];
		String L10 = (String) keyL10;
		
		Object keyL11 = L11.keySet().toArray()[BoxTipoNoExenta.getSelectedIndex()];
		String L11 = (String) keyL11;
		
		Object keyL12 = L12.keySet().toArray()[BoxOperacionRecargo.getSelectedIndex()];
		String L12 = (String) keyL12;
		
		Object keyL13 = L13.keySet().toArray()[BoxCausaNoSujecion.getSelectedIndex()];
		String L13 = (String) keyL13;
		
		DatosXML datos = new DatosXML(IDVersionTBAI, NIF, RazonSocial, L6, L9, L10, L11, L12, L13);
		insert.insertDatosXML(datos, connection);
		manager.disconnect();
	}
}