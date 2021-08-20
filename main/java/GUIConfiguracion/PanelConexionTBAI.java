package GUIConfiguracion;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DBManager.DBManager;
import DBManager.DeleteData;
import DBManager.InsertData;
import DBManager.SelectData;
import DataType.DatosConexion;

public class PanelConexionTBAI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldAlta;
	private JTextField textFieldAnulacion;

	public PanelConexionTBAI(boolean estadoEdicion) {
		
		setBackground(new Color(255, 204, 51));
		setVisible(false);
		
		GridBagLayout gbl_Panelcentral = new GridBagLayout();
		gbl_Panelcentral.columnWidths = new int[]{174, 288, 0, 0};
		gbl_Panelcentral.rowHeights = new int[]{40, 26, 0, 0, 0};
		gbl_Panelcentral.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_Panelcentral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_Panelcentral);
		
		JLabel txtAlta = new JLabel("URL de Alta: ");
		txtAlta.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtAlta = new GridBagConstraints();
		gbc_txtAlta.insets = new Insets(0, 0, 5, 5);
		gbc_txtAlta.anchor = GridBagConstraints.EAST;
		gbc_txtAlta.gridx = 0;
		gbc_txtAlta.gridy = 1;
		add(txtAlta, gbc_txtAlta);
		
		textFieldAlta = new JTextField();
		textFieldAlta.setEditable(estadoEdicion);
		textFieldAlta.setEnabled(estadoEdicion);
		textFieldAlta.setFocusTraversalPolicyProvider(true);
		GridBagConstraints gbc_textFieldAlta = new GridBagConstraints();
		gbc_textFieldAlta.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAlta.fill = GridBagConstraints.BOTH;
		gbc_textFieldAlta.gridx = 1;
		gbc_textFieldAlta.gridy = 1;
		add(textFieldAlta, gbc_textFieldAlta);
		textFieldAlta.setColumns(10);
		
		JLabel txtAnulacion = new JLabel("URL  de Anulaci\u00F3n: ");
		txtAnulacion.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtAnulacion = new GridBagConstraints();
		gbc_txtAnulacion.insets = new Insets(0, 0, 0, 5);
		gbc_txtAnulacion.anchor = GridBagConstraints.EAST;
		gbc_txtAnulacion.gridx = 0;
		gbc_txtAnulacion.gridy = 3;
		add(txtAnulacion, gbc_txtAnulacion);
		
		textFieldAnulacion = new JTextField();
		textFieldAnulacion.setEditable(estadoEdicion);
		textFieldAnulacion.setEnabled(estadoEdicion);
		GridBagConstraints gbc_textFieldAnulacion = new GridBagConstraints();
		gbc_textFieldAnulacion.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldAnulacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAnulacion.gridx = 1;
		gbc_textFieldAnulacion.gridy = 3;
		add(textFieldAnulacion, gbc_textFieldAnulacion);
		textFieldAnulacion.setColumns(10);
		
		cargarDatos();
	}

	public void cargarDatos() {
		DBManager manager = new DBManager();
		manager.connect();
		Connection connection =manager.connection;
		SelectData selection = new SelectData();
		
		DatosConexion datos = selection.selectDatosConexion(connection);
		if (datos != null) {
			textFieldAlta.setText(datos.getEnlaceAlta());
			textFieldAnulacion.setText(datos.getEnlaceBaja());	
		}	
		manager.disconnect();
	}
	
	public void guardarDatos() {
		DBManager manager = new DBManager();
		manager.connect();
		Connection connection = manager.connection;
		
		//En primer lugar, se eliminan los datos que estan previamente guardados en la base de datos
		DeleteData delete = new DeleteData();
		delete.DeleteDatosConexion(connection);
				
		InsertData insert  = new InsertData();
		
		String EnlaceAlta = textFieldAlta.getText();
		String EnlaceAnulacion = textFieldAlta.getText();		
		
		DatosConexion  datosConexion = new DatosConexion(EnlaceAlta, EnlaceAnulacion);
		insert.insertDatosConexion(datosConexion, connection);
		manager.disconnect();
	}
}