package GUIConfiguracion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class DialogSave extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	
	public DialogSave(ConfigureWindow ventanaPadre,String text) {
		setLocationRelativeTo(ventanaPadre);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBackground(new Color(255, 204, 51));
		setForeground(new Color(255, 204, 51));
		setBounds(100, 100, 304, 156);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 0, 268, 79);
		textPane.setText(text);
		contentPanel.add(textPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventanaPadre.guardarDatosDatabase();
						ventanaPadre.buttonEditar.setBackground(new Color(51, 102, 153));
						ventanaPadre.estadoEdicion = false;
						dispose();

					}
				});
				okButton.setActionCommand("Guardar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventanaPadre.buttonEditar.setBackground(new Color(51, 102, 153));
						ventanaPadre.estadoEdicion = false;
						dispose();

					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}
}
