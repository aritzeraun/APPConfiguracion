package GUIConfiguracion;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DBManager.DBManager;
import DBManager.DeleteData;
import DBManager.InsertData;
import DBManager.SelectData;
import DataType.FirmaElectronica;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class PanelFirmaElectronica extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtFieldLicenciaTBAI;
	private JTextField textFieldNIF;
	private JLabel lblNewLabel;
	private JTextField textFieldID;
	private JTextField textFieldNombre;
	private JTextField textFieldVersion;
	private JLabel txtNombre;
	private JLabel txtVersion;
	private JPanel panel;
	private JComboBox<String> boxCodigoPais;
	private JComboBox<String> boxIDType;
	private JCheckBox CheckBoxNIF ;
	private JCheckBox CheckBoxIDOtro;
	private JLabel txtCodigoPais;
	private JLabel txtIDType;
	private JLabel txtID;
	private JTextField textFieldNumSerieDispositivo;
	private JLabel txtNumSerieDispositivo;
	
	private HashMap<String, String> L1 ;
	private HashMap<String, String> L2;
	private String name;
	private String url;

	public PanelFirmaElectronica(boolean estadoEdicion, String name, String url) {
		this.name = name;
		this.url = url;
		
		setBackground(new Color(255, 204, 51));
		setVisible(false);
		
		GridBagLayout gbl_Panelcentral = new GridBagLayout();
		gbl_Panelcentral.columnWidths = new int[]{174, 288, 0, 0};
		gbl_Panelcentral.rowHeights = new int[]{40, 26, 35, 0, 0, 0, 0, 0, 0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0};
		gbl_Panelcentral.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_Panelcentral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_Panelcentral);
		
		JLabel txtLicenciaTBAI = new JLabel("Licencia TBAI: ");
		txtLicenciaTBAI.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtLicenciaTBAI = new GridBagConstraints();
		gbc_txtLicenciaTBAI.insets = new Insets(0, 0, 5, 5);
		gbc_txtLicenciaTBAI.anchor = GridBagConstraints.EAST;
		gbc_txtLicenciaTBAI.gridx = 0;
		gbc_txtLicenciaTBAI.gridy = 1;
		add(txtLicenciaTBAI, gbc_txtLicenciaTBAI);
		
		txtFieldLicenciaTBAI = new JTextField();
		txtFieldLicenciaTBAI.setEditable(estadoEdicion);
		txtFieldLicenciaTBAI.setEnabled(estadoEdicion);
		txtFieldLicenciaTBAI.setFocusTraversalPolicyProvider(true);
		GridBagConstraints gbc_txtIFieldLicenciaTBAI = new GridBagConstraints();
		gbc_txtIFieldLicenciaTBAI.insets = new Insets(0, 0, 5, 5);
		gbc_txtIFieldLicenciaTBAI.fill = GridBagConstraints.BOTH;
		gbc_txtIFieldLicenciaTBAI.gridx = 1;
		gbc_txtIFieldLicenciaTBAI.gridy = 1;
		add(txtFieldLicenciaTBAI, gbc_txtIFieldLicenciaTBAI);
		txtFieldLicenciaTBAI.setColumns(10);
		
		lblNewLabel = new JLabel("Persona o Entidad Desarrolladora");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel txtNIF = new JLabel("NIF: ");
		txtNIF.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtNIF = new GridBagConstraints();
		gbc_txtNIF.insets = new Insets(0, 0, 5, 5);
		gbc_txtNIF.anchor = GridBagConstraints.EAST;
		gbc_txtNIF.gridx = 0;
		gbc_txtNIF.gridy = 3;
		add(txtNIF, gbc_txtNIF);
		
		textFieldNIF = new JTextField();
		textFieldNIF.setEditable(estadoEdicion);
		textFieldNIF.setEnabled(estadoEdicion);
		GridBagConstraints gbc_textFieldNIF = new GridBagConstraints();
		gbc_textFieldNIF.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNIF.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNIF.gridx = 1;
		gbc_textFieldNIF.gridy = 3;
		add(textFieldNIF, gbc_textFieldNIF);
		textFieldNIF.setColumns(10);
		
		txtCodigoPais = new JLabel("Codigo Pa\u00EDs: ");
		txtCodigoPais.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtCodigoPais = new GridBagConstraints();
		gbc_txtCodigoPais.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodigoPais.anchor = GridBagConstraints.EAST;
		gbc_txtCodigoPais.gridx = 0;
		gbc_txtCodigoPais.gridy = 5;
		add(txtCodigoPais, gbc_txtCodigoPais);
		
		boxCodigoPais = new JComboBox<String>();
		boxCodigoPais.setEnabled(false);
		
		//Cargar datos de Codigo Pais -L1-
		cargarDatos(1);
		
		boxCodigoPais.setEditable(false);
		GridBagConstraints gbc_boxCodigoPais = new GridBagConstraints();
		gbc_boxCodigoPais.insets = new Insets(0, 0, 5, 5);
		gbc_boxCodigoPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_boxCodigoPais.gridx = 1;
		gbc_boxCodigoPais.gridy = 5;
		add(boxCodigoPais, gbc_boxCodigoPais);
		
		txtIDType = new JLabel("ID type: ");
		txtIDType.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtIDType = new GridBagConstraints();
		gbc_txtIDType.insets = new Insets(0, 0, 5, 5);
		gbc_txtIDType.anchor = GridBagConstraints.EAST;
		gbc_txtIDType.gridx = 0;
		gbc_txtIDType.gridy = 7;
		add(txtIDType, gbc_txtIDType);
		
		boxIDType = new JComboBox<String>();
		
		//Cargar datos de ID Type -L2-
		cargarDatos(2);
		
		boxIDType.setEditable(false);
		boxIDType.setEnabled(false);
		GridBagConstraints gbc_boxIDType = new GridBagConstraints();
		gbc_boxIDType.insets = new Insets(0, 0, 5, 5);
		gbc_boxIDType.fill = GridBagConstraints.HORIZONTAL;
		gbc_boxIDType.gridx = 1;
		gbc_boxIDType.gridy = 7;
		add(boxIDType, gbc_boxIDType);
		
		txtID = new JLabel("ID: ");
		txtID.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtID = new GridBagConstraints();
		gbc_txtID.insets = new Insets(0, 0, 5, 5);
		gbc_txtID.anchor = GridBagConstraints.EAST;
		gbc_txtID.gridx = 0;
		gbc_txtID.gridy = 9;
		add(txtID, gbc_txtID);
		
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setEnabled(false);
		GridBagConstraints gbc_textFieldID = new GridBagConstraints();
		gbc_textFieldID.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldID.gridx = 1;
		gbc_textFieldID.gridy = 9;
		add(textFieldID, gbc_textFieldID);
		textFieldID.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 204, 51));
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 11;
		add(panel, gbc_panel);
		
		CheckBoxNIF = new JCheckBox("NIF");
		CheckBoxNIF.setEnabled(estadoEdicion);
		CheckBoxNIF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckBoxNIF.isSelected() == true) {
					textFieldNIF.setEditable(true);
					textFieldNIF.setEnabled(true);
					
					CheckBoxIDOtro.setSelected(false);
					boxIDType.setEditable(false);
					boxIDType.setEnabled(false);
					boxCodigoPais.setEditable(false);
					boxCodigoPais.setEnabled(false);
					textFieldID.setEditable(false);
					textFieldID.setEnabled(false);
				}else{
					textFieldNIF.setEditable(false);
					textFieldNIF.setEnabled(false);
				}
			}
		});
		CheckBoxNIF.setSelected(true);
		CheckBoxNIF.setBackground(new Color(255, 204, 0));
		CheckBoxNIF.setBounds(21, 17, 97, 23);
		panel.add(CheckBoxNIF);
		
		CheckBoxIDOtro = new JCheckBox("ID Otro");
		CheckBoxIDOtro.setEnabled(estadoEdicion);
		CheckBoxIDOtro.setBackground(new Color(255, 204, 0));
		CheckBoxIDOtro.setBounds(147, 17, 97, 23);
		CheckBoxIDOtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckBoxIDOtro.isSelected() == true) {
					textFieldNIF.setEditable(false);
					textFieldNIF.setEnabled(false);
					CheckBoxNIF.setSelected(false);
					
					boxIDType.setEnabled(true);
					boxCodigoPais.setEnabled(true);
					textFieldID.setEditable(true);
					textFieldID.setEnabled(true);
				}else{
					boxIDType.setEnabled(false);
					boxCodigoPais.setEnabled(false);
					textFieldID.setEditable(false);
					textFieldID.setEnabled(false);
				}
			}
		});
		panel.add(CheckBoxIDOtro);
		
		txtNombre = new JLabel("Nombre: ");
		txtNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.anchor = GridBagConstraints.EAST;
		gbc_txtNombre.gridx = 0;
		gbc_txtNombre.gridy = 13;
		add(txtNombre, gbc_txtNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEnabled(estadoEdicion);
		textFieldNombre.setEditable(estadoEdicion);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 13;
		add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		txtVersion = new JLabel("Versi\u00F3n: ");
		txtVersion.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtVersion = new GridBagConstraints();
		gbc_txtVersion.insets = new Insets(0, 0, 5, 5);
		gbc_txtVersion.anchor = GridBagConstraints.EAST;
		gbc_txtVersion.gridx = 0;
		gbc_txtVersion.gridy = 15;
		add(txtVersion, gbc_txtVersion);
		
		textFieldVersion = new JTextField();
		textFieldVersion.setEnabled(estadoEdicion);
		textFieldVersion.setEditable(estadoEdicion);
		GridBagConstraints gbc_textFieldVersion = new GridBagConstraints();
		gbc_textFieldVersion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVersion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVersion.gridx = 1;
		gbc_textFieldVersion.gridy = 15;
		add(textFieldVersion, gbc_textFieldVersion);
		textFieldVersion.setColumns(10);
		
		txtNumSerieDispositivo = new JLabel("N\u00BA de Serie de Dispositivo: ");
		txtNumSerieDispositivo.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtNumSerieDispositivo = new GridBagConstraints();
		gbc_txtNumSerieDispositivo.insets = new Insets(0, 0, 0, 5);
		gbc_txtNumSerieDispositivo.anchor = GridBagConstraints.EAST;
		gbc_txtNumSerieDispositivo.gridx = 0;
		gbc_txtNumSerieDispositivo.gridy = 17;
		add(txtNumSerieDispositivo, gbc_txtNumSerieDispositivo);
		
		textFieldNumSerieDispositivo = new JTextField();
		textFieldNumSerieDispositivo.setEnabled(estadoEdicion);
		textFieldNumSerieDispositivo.setEditable(estadoEdicion);
		GridBagConstraints gbc_textFieldNumSerieDispositivo = new GridBagConstraints();
		gbc_textFieldNumSerieDispositivo.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldNumSerieDispositivo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumSerieDispositivo.gridx = 1;
		gbc_textFieldNumSerieDispositivo.gridy = 17;
		add(textFieldNumSerieDispositivo, gbc_textFieldNumSerieDispositivo);
		textFieldNumSerieDispositivo.setColumns(10);
		
		cargarValoresTexto();
	}
	
	public void cargarDatos(int tipo) {
		DBManager manager = new DBManager(name, url);
		manager.connect();
		Connection connection =manager.connection;
		SelectData selection = new SelectData();
		
		if(tipo == 1) {
			L1 = selection.selectL1(connection);
			for(int i = 0;i <L1.size();i++) {
				Object firstKey = L1.keySet().toArray()[i];
				Object valueForFirstKey = L1.get(firstKey);
				boxCodigoPais.addItem(new String(firstKey+" - "+valueForFirstKey));
			}
		}else if (tipo == 2) {
			L2 = selection.selectL2(connection);
			for(int i = 0;i <L2.size();i++) {
				Object firstKey = L2.keySet().toArray()[i];
				Object valueForFirstKey = L2.get(firstKey);
				boxIDType.addItem(new String(firstKey+" - "+valueForFirstKey));
			}
		}
		manager.disconnect();
	}
	public void cargarValoresTexto() {
		DBManager manager = new DBManager(name, url);
		manager.connect();
		Connection connection =manager.connection;
		SelectData selection = new SelectData();
		FirmaElectronica firma = selection.selectFirmaElectronica(connection);
		if (firma != null) {
			txtFieldLicenciaTBAI.setText(firma.getLicenciaTBAI());;
			
			if (firma.getNIF() != null) {
				textFieldNIF.setText(firma.getNIF());
			}
			
			if(firma.getCodigoPais() != null) {
				//se selecciona la opcion guarda por ultima vez en el campo Codigo pais
				for (int i = 0; i < boxCodigoPais.getItemCount(); i++) {
					String texto = boxCodigoPais.getItemAt(i).toString();
					texto = texto.substring(0, 2);
					
					if(texto.equals(firma.getCodigoPais())) {
						boxCodigoPais.setSelectedIndex(i);
					}
				}
				
				//se selecciona la opcion guarda por ultima vez en el campo IDType
				for (int i = 0; i < boxIDType.getItemCount(); i++) {
					String texto = boxIDType.getItemAt(i).toString();
					texto = texto.substring(0, 2);
					
					if(texto.equals(firma.getIDType())) {
						boxIDType.setSelectedIndex(i);
					}
				}
			}
			textFieldID.setText(firma.getID());;
			textFieldNombre.setText(firma.getNombre());
			textFieldVersion.setText(firma.getVersion());;
			textFieldNumSerieDispositivo.setText(firma.getDispositivo());
		}
		manager.disconnect();
	}
	public void guardarDatos() {
		DBManager manager = new DBManager(name, url);
		manager.connect();
		Connection connection = manager.connection;
		
		//En primer lugar, se eliminan los datos que estan previamente guardados en la base de datos
		DeleteData delete = new DeleteData();
		delete.DeleteFirmaElectronica(connection);
		
		InsertData insert  = new InsertData();
		
		String LicenciaTBAI = txtFieldLicenciaTBAI.getText();;
		String NIF = null;
		if (CheckBoxNIF.isSelected() != false) {
			NIF = textFieldNIF.getText();
		}
		
		String ID = null;
		String CodigoPais = null;
		String IDType = null;
		
		if (CheckBoxIDOtro.isSelected() != false) {
			ID = textFieldID.getText();
			CodigoPais = boxCodigoPais.getItemAt(boxCodigoPais.getSelectedIndex()).toString();
			CodigoPais = CodigoPais.substring(0, 2);
			
			IDType = boxIDType.getItemAt(boxIDType.getSelectedIndex()).toString();
			IDType = IDType.substring(0, 2);
		}
		
		String Nombre = textFieldNombre.getText();
		String Version = textFieldVersion.getText();;
		String Dispositivo = textFieldNumSerieDispositivo.getText();
		
		FirmaElectronica firma = new FirmaElectronica(LicenciaTBAI,NIF,CodigoPais,IDType,ID,Nombre,Version,Dispositivo);
		insert.insertFirmaElectronica(firma, connection);
		manager.disconnect();
	}
}