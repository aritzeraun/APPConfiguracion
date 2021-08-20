package GUIConfiguracion;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDatosBasicos extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtIepa;
	private JTextField textField_1;

	public PanelDatosBasicos() {
		
		setBackground(new Color(255, 204, 51));
		setVisible(false);
		
		GridBagLayout gbl_Panelcentral = new GridBagLayout();
		gbl_Panelcentral.columnWidths = new int[]{174, 288, 0, 0};
		gbl_Panelcentral.rowHeights = new int[]{96, 26, 0, 0, 0};
		gbl_Panelcentral.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_Panelcentral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_Panelcentral);
		
		JLabel lblNewLabel_1 = new JLabel("URL de ALta:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtIepa = new JTextField();
		txtIepa.setText("iepa");
		txtIepa.setFocusTraversalPolicyProvider(true);
		GridBagConstraints gbc_txtIepa = new GridBagConstraints();
		gbc_txtIepa.insets = new Insets(0, 0, 5, 5);
		gbc_txtIepa.fill = GridBagConstraints.BOTH;
		gbc_txtIepa.gridx = 1;
		gbc_txtIepa.gridy = 1;
		add(txtIepa, gbc_txtIepa);
		txtIepa.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("URL Anulaci\u00F3n");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 3;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
	}

}
