package GUIConfiguracion;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DBManager.DBManager;
import DBManager.InsertData;
import DBManager.SelectData;
import DataType.DatosBasicos;
import ReadingFiles.FicheroOculto;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelDatosBasicos extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtFieldArchivosXML;
	private JTextField textFieldRecursos;
	private JButton ButtonXML;
	private JTextField textFieldBD;
	private JButton ButtonRecursos;
	private JButton ButtonBD;
	private JLabel lblNewLabel;
	private JLabel txtDirectorioBD;
	private String name;
	private String url;
	private JTextField textFieldNombreBD;
	private JLabel txtNombreBD;

	public PanelDatosBasicos(boolean estadoEdicion, String name,String  url) {
		
		this.name = name;
		this.url = url;
		
		setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		
		setBackground(new Color(255, 204, 51));
		setVisible(false);
		
		GridBagLayout gbl_Panelcentral = new GridBagLayout();
		gbl_Panelcentral.columnWidths = new int[]{174, 403, -1, 0};
		gbl_Panelcentral.rowHeights = new int[]{80, 26, 0, 0, 0, 0, 0, 0, 0};
		gbl_Panelcentral.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Panelcentral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_Panelcentral);
		
		lblNewLabel = new JLabel("<html><body style='width: 350px; text-align: justify;'>A continuaci\u00F3n se muestran los distintos directorios o direcciones de relevancia para el correcto funcionamiento del sistema. Configure dichas direecciones a corde con las necesidades: ");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel txtDirectorioXML = new JLabel("Directorio de archivos XML: ");
		txtDirectorioXML.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtDirectorioXML = new GridBagConstraints();
		gbc_txtDirectorioXML.insets = new Insets(0, 0, 5, 5);
		gbc_txtDirectorioXML.anchor = GridBagConstraints.EAST;
		gbc_txtDirectorioXML.gridx = 0;
		gbc_txtDirectorioXML.gridy = 1;
		add(txtDirectorioXML, gbc_txtDirectorioXML);
		
		
		txtFieldArchivosXML = new JTextField();
		txtFieldArchivosXML.setEnabled(estadoEdicion);
		txtFieldArchivosXML.setEditable(estadoEdicion);
		txtFieldArchivosXML.setFocusTraversalPolicyProvider(true);
		GridBagConstraints gbc_txtIepa = new GridBagConstraints();
		gbc_txtIepa.insets = new Insets(0, 0, 5, 5);
		gbc_txtIepa.fill = GridBagConstraints.BOTH;
		gbc_txtIepa.gridx = 1;
		gbc_txtIepa.gridy = 1;
		add(txtFieldArchivosXML, gbc_txtIepa);
		txtFieldArchivosXML.setColumns(10);
		
		ButtonXML = new JButton("");
		ButtonXML.setEnabled(estadoEdicion);
		ButtonXML.setBackground(new Color(204, 102, 0));
		ButtonXML.setBorderPainted(false);
		ButtonXML.setFocusable(false);
		ButtonXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String direccion = seleccionDirectorio();
				if (direccion != null) {
					txtFieldArchivosXML.setText(direccion);
				}
			}
		});
		ButtonXML.setIcon(new ImageIcon(".\\src\\main\\resources\\Iconos\\IconoDatosAlmacenamiento.png"));
		GridBagConstraints gbc_ButtonXML = new GridBagConstraints();
		gbc_ButtonXML.insets = new Insets(0, 0, 5, 0);
		gbc_ButtonXML.gridx = 2;
		gbc_ButtonXML.gridy = 1;
		add(ButtonXML, gbc_ButtonXML);
		
		JLabel txtDirecetorioRecursos = new JLabel("Directorio a Recursos del Sistema: ");
		txtDirecetorioRecursos.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtDirecetorioRecursos = new GridBagConstraints();
		gbc_txtDirecetorioRecursos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDirecetorioRecursos.insets = new Insets(0, 0, 5, 5);
		gbc_txtDirecetorioRecursos.gridx = 0;
		gbc_txtDirecetorioRecursos.gridy = 3;
		add(txtDirecetorioRecursos, gbc_txtDirecetorioRecursos);
		
		textFieldRecursos = new JTextField();
		textFieldRecursos.setEditable(estadoEdicion);
		textFieldRecursos.setEnabled(estadoEdicion);
		GridBagConstraints gbc_textFieldRecursos = new GridBagConstraints();
		gbc_textFieldRecursos.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRecursos.fill = GridBagConstraints.BOTH;
		gbc_textFieldRecursos.gridx = 1;
		gbc_textFieldRecursos.gridy = 3;
		add(textFieldRecursos, gbc_textFieldRecursos);
		textFieldRecursos.setColumns(10);
		
		ButtonRecursos = new JButton("");
		ButtonRecursos.setEnabled(estadoEdicion);
		ButtonRecursos.setBackground(new Color(204, 102, 0));
		ButtonRecursos.setIcon(new ImageIcon(".\\src\\main\\resources\\Iconos\\IconoDatosAlmacenamiento.png"));
		ButtonRecursos.setFocusable(false);
		ButtonRecursos.setBorderPainted(false);
		ButtonRecursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String direccion = seleccionDirectorio();
				if (direccion != null) {
					textFieldRecursos.setText(direccion);
				}
			}
		});
		GridBagConstraints gbc_ButtonRecursos = new GridBagConstraints();
		gbc_ButtonRecursos.insets = new Insets(0, 0, 5, 0);
		gbc_ButtonRecursos.gridx = 2;
		gbc_ButtonRecursos.gridy = 3;
		add(ButtonRecursos, gbc_ButtonRecursos);
		
		txtDirectorioBD = new JLabel("Directorio a Base de Datos: ");
		txtDirectorioBD.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtDirectorioBD = new GridBagConstraints();
		gbc_txtDirectorioBD.insets = new Insets(0, 0, 5, 5);
		gbc_txtDirectorioBD.anchor = GridBagConstraints.EAST;
		gbc_txtDirectorioBD.gridx = 0;
		gbc_txtDirectorioBD.gridy = 5;
		add(txtDirectorioBD, gbc_txtDirectorioBD);
		
		textFieldBD = new JTextField();
		textFieldBD.setEditable(estadoEdicion);
		textFieldBD.setEnabled(estadoEdicion);
		GridBagConstraints gbc_textFieldBD = new GridBagConstraints();
		gbc_textFieldBD.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBD.fill = GridBagConstraints.BOTH;
		gbc_textFieldBD.gridx = 1;
		gbc_textFieldBD.gridy = 5;
		add(textFieldBD, gbc_textFieldBD);
		textFieldBD.setColumns(10);
		
		ButtonBD = new JButton();
		ButtonBD.setEnabled(estadoEdicion);
		ButtonBD.setBackground(new Color(204, 102, 0));
		ButtonBD.setIcon(new ImageIcon(".\\src\\main\\resources\\Iconos\\IconoDatosAlmacenamiento.png"));
		ButtonBD.setFocusable(false);
		ButtonBD.setBorderPainted(false);
		ButtonBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String direccion = seleccionDirectorio();
				if (direccion != null) {
					textFieldBD.setText(direccion);
				}
			}
		});
		GridBagConstraints gbc_ButtonBD = new GridBagConstraints();
		gbc_ButtonBD.insets = new Insets(0, 0, 5, 0);
		gbc_ButtonBD.gridx = 2;
		gbc_ButtonBD.gridy = 5;
		add(ButtonBD, gbc_ButtonBD);
		
		txtNombreBD = new JLabel("Nombre de Base de Datos: ");
		txtNombreBD.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_txtNombreBD = new GridBagConstraints();
		gbc_txtNombreBD.insets = new Insets(0, 0, 0, 5);
		gbc_txtNombreBD.anchor = GridBagConstraints.EAST;
		gbc_txtNombreBD.gridx = 0;
		gbc_txtNombreBD.gridy = 7;
		add(txtNombreBD, gbc_txtNombreBD);
		
		textFieldNombreBD = new JTextField();
		textFieldNombreBD.setEditable(estadoEdicion);
		textFieldNombreBD.setEnabled(estadoEdicion);
		GridBagConstraints gbc_textFieldNombreBD = new GridBagConstraints();
		gbc_textFieldNombreBD.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldNombreBD.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombreBD.gridx = 1;
		gbc_textFieldNombreBD.gridy = 7;
		add(textFieldNombreBD, gbc_textFieldNombreBD);
		textFieldNombreBD.setColumns(10);
		
		cargarDatos();
	}
	
	public String seleccionDirectorio() {
		
		JFileChooser selector = new JFileChooser();
		selector.setCurrentDirectory(new File("."));
		selector.setDialogTitle("Carpeta de almacenamiento de ficheros XML");
		selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		selector.setAcceptAllFileFilterUsed(false);
		selector.setVisible(true);
		String direccion = null;
		
		if(selector.showOpenDialog(this) ==JFileChooser.APPROVE_OPTION) {
			File carpetaSeleccionada = selector.getCurrentDirectory();
			direccion =carpetaSeleccionada.getAbsolutePath();
		}
		return direccion;
	}
	
	public void cargarDatos() {
		DBManager manager = new DBManager(name,url);
		manager.connect();
		Connection connection =manager.connection;
		SelectData selection = new SelectData();
		DatosBasicos datos = selection.selectDatoBasicos(connection);
		if (datos != null) {
			txtFieldArchivosXML.setText(datos.getDirectorioArchivosXML());
			textFieldRecursos.setText(datos.getDirectorioRecursos());
			textFieldBD.setText(datos.getDirectorioBaseDatos());
			textFieldNombreBD.setText(datos.getNombreBaseBatos());
		}
		
		manager.disconnect();
	}

	public void guardarDatos() {
		DBManager manager = new DBManager(name, url);
		manager.connect();
		Connection connection = manager.connection;
		InsertData insert  = new InsertData();
		
		String DirectorioRecursos = textFieldRecursos.getText();
		String DirectorioBD = textFieldBD.getText();
		String DirectorioXML = txtFieldArchivosXML.getText();
		String NombreBaseBatos = textFieldNombreBD.getText();
		if(NombreBaseBatos.endsWith(".db") == false) {
			NombreBaseBatos = NombreBaseBatos +".db";
		}
		
		DatosBasicos datos = new DatosBasicos(DirectorioXML, DirectorioRecursos,DirectorioBD,NombreBaseBatos);
		insert.insertDatosBasicos(datos, connection);
		manager.disconnect();
	}
	
	public void moverFicheros(String recursos) {
		FicheroOculto fichero = new FicheroOculto();
		try {
			fichero.moverFiceheros(textFieldRecursos.getText(), recursos,textFieldNombreBD.getText(), name,textFieldBD.getText(), url );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}