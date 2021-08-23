package GUIConfiguracion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class ConfigureWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelDatosBasicos PanelDatosBasicos;
	private PanelDatosXML PanelDatosXML;
	private PanelConexionTBAI PanelConexionTBAI;
	private PanelFirmaElectronica PanelFirmaElectronica;
	public JButton buttonEditar;
	private JButton DatosBasicos;
	private JButton ButtonConexionTBAI;
	private JButton ButtonDatosXML;
	private JButton ButtonFirmaElectronica;
	private int ventana = 1;
	
	public boolean estadoEdicion = false;
	private String name;
	private String url;
	private String recursos;
	
	public ConfigureWindow(String name, String url, String recursos) {
		
		this.name = name;
		this.url =url;
		this.recursos = recursos;
		
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\src\\main\\resources\\Iconos\\LogoMiniatura.png"));
		setTitle("Configuraci\u00F3n APP TicketBAI\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 792);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[133px][833.00px,grow,fill]", "[100px][778.00px,grow]"));
		
		JPanel PanelSuperior = new JPanel();
		PanelSuperior.setBackground(new Color(255, 255, 255));
		contentPane.add(PanelSuperior, "cell 0 0 2 1,growx,aligny top");
		GridBagLayout gbl_PanelSuperior = new GridBagLayout();
		gbl_PanelSuperior.columnWidths = new int[]{152, 2, 137, 61, 0};
		gbl_PanelSuperior.rowHeights = new int[]{95, 0};
		gbl_PanelSuperior.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_PanelSuperior.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		PanelSuperior.setLayout(gbl_PanelSuperior);
		
		JLabel IconoLogo = new JLabel("");
		IconoLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		IconoLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
		IconoLogo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		IconoLogo.setIcon(new ImageIcon(".\\src\\main\\resources\\Iconos\\LogoArcelorMittal.png"));
		GridBagConstraints gbc_IconoLogo = new GridBagConstraints();
		gbc_IconoLogo.anchor = GridBagConstraints.NORTHWEST;
		gbc_IconoLogo.insets = new Insets(0, 0, 0, 5);
		gbc_IconoLogo.gridx = 0;
		gbc_IconoLogo.gridy = 0;
		PanelSuperior.add(IconoLogo, gbc_IconoLogo);
		
		buttonEditar = new JButton("Editar");
		buttonEditar.setVerticalTextPosition(SwingConstants.BOTTOM);
		buttonEditar.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonEditar.setIcon(new ImageIcon(".\\src\\main\\resources\\Iconos\\IconoEditar.png"));
		buttonEditar.setBackground(new Color(51, 102, 153));
		buttonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(estadoEdicion == false) {
					buttonEditar.setBackground(new Color(204, 102, 0));
					estadoEdicion = true;
				}else {
					buttonEditar.setBackground(new Color(51, 102, 153));
					estadoEdicion = false;
				}
				CambairEstadoEdicion();
	
			}
		});
		buttonEditar.setBorderPainted(false);
		GridBagConstraints gbc_buttonEditar = new GridBagConstraints();
		gbc_buttonEditar.anchor = GridBagConstraints.EAST;
		gbc_buttonEditar.insets = new Insets(0, 0, 0, 5);
		gbc_buttonEditar.gridx = 2;
		gbc_buttonEditar.gridy = 0;
		PanelSuperior.add(buttonEditar, gbc_buttonEditar);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setBorderPainted(false);
		botonGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
		botonGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonGuardar.setBackground(new Color(51, 102, 153));
		GridBagConstraints gbc_botonGuardar = new GridBagConstraints();
		gbc_botonGuardar.gridx = 3;
		gbc_botonGuardar.gridy = 0;
		PanelSuperior.add(botonGuardar, gbc_botonGuardar);
		botonGuardar.setIcon(new ImageIcon(".\\src\\main\\resources\\Iconos\\IconoGuardar.png"));
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarDatosDatabase();
			}
		});
		PanelDatosBasicos= new PanelDatosBasicos(false,name, url);
		contentPane.add(PanelDatosBasicos, "cell 1 1,grow");
		PanelDatosBasicos.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 102));
		contentPane.add(panel, "cell 0 1,alignx left,growy");
		panel.setLayout(new MigLayout("", "[]", "[][][][][]"));
		
		DatosBasicos = new JButton("Datos B\u00E1sicos");
		DatosBasicos.setHorizontalAlignment(SwingConstants.LEFT);
		DatosBasicos.setIcon(new ImageIcon(".\\src\\main\\resources\\Iconos\\IconoDatosAlmacenamiento.png"));
		DatosBasicos.setFocusable(false);
		DatosBasicos.setBorderPainted(false);
		DatosBasicos.setForeground(new Color(0, 0, 0));
		DatosBasicos.setFont(new Font("Verdana", Font.PLAIN, 11));
		DatosBasicos.setBackground(new Color(204, 102, 0));
		DatosBasicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambairColorBotonesYEstadosPaneles();
				DatosBasicos.setBackground(new Color(204, 102, 0));
				
				PanelDatosBasicos = new PanelDatosBasicos(estadoEdicion, name, url);
				contentPane.add(PanelDatosBasicos, "cell 1 1,grow");
				PanelDatosBasicos.setVisible(true);
				contentPane.validate();
				ventana = 1;
			}
		});
		panel.add(DatosBasicos, "cell 0 0,growx");
		
		ButtonDatosXML = new JButton("Datos XML");
		ButtonDatosXML.setFont(new Font("Verdana", Font.PLAIN, 11));
		ButtonDatosXML.setHorizontalAlignment(SwingConstants.LEFT);
		ButtonDatosXML.setBorderPainted(false);
		ButtonDatosXML.setIcon(new ImageIcon(".\\src\\main\\resources\\Iconos\\IconoDatosXML.png"));
		ButtonDatosXML.setBackground(new Color(255, 204, 102));
		ButtonDatosXML.setFocusable(false);
		ButtonDatosXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambairColorBotonesYEstadosPaneles();
				ButtonDatosXML.setBackground(new Color(204, 102, 0));
				
				PanelDatosXML = new PanelDatosXML(estadoEdicion, name, url);
				contentPane.add(PanelDatosXML, "cell 1 1,grow");
				PanelDatosXML.setVisible(true);
				contentPane.validate();
				ventana = 3;
			}
		});
				
		ButtonConexionTBAI = new JButton("Conexion TBAI");
		ButtonConexionTBAI.setFont(new Font("Verdana", Font.PLAIN, 11));
		ButtonConexionTBAI.setHorizontalAlignment(SwingConstants.LEFT);
		ButtonConexionTBAI.setFocusable(false);
		ButtonConexionTBAI.setBorderPainted(false);
		ButtonConexionTBAI.setBackground(new Color(255, 204, 102));
		ButtonConexionTBAI.setIcon(new ImageIcon(".\\src\\main\\resources\\Iconos\\IconoEnlaces.png"));
		
		ButtonConexionTBAI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambairColorBotonesYEstadosPaneles();
				ButtonConexionTBAI.setBackground(new Color(204, 102, 0));
				
				PanelConexionTBAI = new PanelConexionTBAI(estadoEdicion, name, url);
				contentPane.add(PanelConexionTBAI, "cell 1 1,grow");
				PanelConexionTBAI.setVisible(true);
				contentPane.validate();	
				ventana = 2;
			}
		});
		panel.add(ButtonConexionTBAI, "cell 0 1,growx");
		panel.add(ButtonDatosXML, "cell 0 2,growx");
		
		ButtonFirmaElectronica = new JButton("Firma Electr\u00F3nica");
		ButtonFirmaElectronica.setFont(new Font("Verdana", Font.PLAIN, 11));
		ButtonFirmaElectronica.setFocusable(false);
		ButtonFirmaElectronica.setIcon(new ImageIcon(".\\src\\main\\resources\\Iconos\\IconoFirmaElectronica.png"));
		ButtonFirmaElectronica.setBackground(new Color(255, 204, 102));
		ButtonFirmaElectronica.setBorderPainted(false);
		ButtonFirmaElectronica.setHorizontalAlignment(SwingConstants.LEFT);
		ButtonFirmaElectronica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambairColorBotonesYEstadosPaneles();
				ButtonFirmaElectronica.setBackground(new Color(204, 102, 0));
				
				PanelFirmaElectronica = new PanelFirmaElectronica(estadoEdicion, name, url);
				contentPane.add(PanelFirmaElectronica, "cell 1 1,grow");
				PanelFirmaElectronica.setVisible(true);
				contentPane.validate();
				ventana = 4;
			}
		});
		panel.add(ButtonFirmaElectronica, "cell 0 3,growx");		
	}
	
	public void CambairColorBotonesYEstadosPaneles() {
		DatosBasicos.setBackground(new Color(255, 204, 102));
		ButtonConexionTBAI.setBackground(new Color(255, 204, 102));
		ButtonDatosXML.setBackground(new Color(255, 204, 102));
		ButtonFirmaElectronica.setBackground(new Color(255, 204, 102));
		
		if (estadoEdicion == true) {
			DialogSave menssage = new DialogSave(this, "Se encuentra en modo edcici\u00F3n de datos. \u00BFDesea guardar los datos modificados?");
		
			menssage.setLocationRelativeTo(this);
			menssage.setVisible(true);
		}
			
			if(PanelDatosBasicos !=null) {
				PanelDatosBasicos.setVisible(false);
				contentPane.remove(PanelDatosBasicos);
			}
			
			if(PanelConexionTBAI !=null) {
				PanelConexionTBAI.setVisible(false);
				contentPane.remove(PanelConexionTBAI);
			}
			
			if(PanelDatosXML !=null) {
				PanelDatosXML.setVisible(false);
				contentPane.remove(PanelDatosXML);
			}
			
			if(PanelFirmaElectronica !=null ) {
				PanelFirmaElectronica.setVisible(false);
				contentPane.remove(PanelFirmaElectronica);
			}
	}
	
	public void CambairEstadoEdicion() {
		
		if(ventana == 1) {
			PanelDatosBasicos.setVisible(false);
			contentPane.remove(PanelDatosBasicos);
			
			PanelDatosBasicos = new PanelDatosBasicos(estadoEdicion, name, url);
			contentPane.add(PanelDatosBasicos, "cell 1 1,grow");
			PanelDatosBasicos.setVisible(true);
			contentPane.validate();
		}
		else if (ventana == 2) {
			PanelConexionTBAI.setVisible(false);
			contentPane.remove(PanelConexionTBAI);
			
			PanelConexionTBAI = new PanelConexionTBAI(estadoEdicion,name, url);
			contentPane.add(PanelConexionTBAI, "cell 1 1,grow");
			PanelConexionTBAI.setVisible(true);
			contentPane.validate();
		}
		else if (ventana == 3) {
			PanelDatosXML.setVisible(false);
			contentPane.remove(PanelDatosXML); 
			
			PanelDatosXML = new PanelDatosXML(estadoEdicion, name, url);
			contentPane.add(PanelDatosXML, "cell 1 1,grow");
			PanelDatosXML.setVisible(true);
			contentPane.validate();
		}
		else if (ventana == 4) {
			PanelFirmaElectronica.setVisible(false);
			contentPane.remove(PanelFirmaElectronica);
			
			PanelFirmaElectronica = new PanelFirmaElectronica(estadoEdicion, name, url);
			contentPane.add(PanelFirmaElectronica, "cell 1 1,grow");
			PanelFirmaElectronica.setVisible(true);
			contentPane.validate();
		}
	}
	
	public void guardarDatosDatabase() {
			
		if(ventana == 1) {
			PanelDatosBasicos.guardarDatos();
			PanelDatosBasicos.moverFicheros(recursos);
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));;
			
		}else if (ventana == 2) {
			PanelConexionTBAI.guardarDatos();
			
		}else if (ventana == 3) {
			PanelDatosXML.guardarDatos();
			
		}else if (ventana == 4) {
			PanelFirmaElectronica.guardarDatos();	
		}
	}
}