package gui.ABMclientes;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import businessDelegate.BusinessDelegate;

public class BajaCliente extends JFrame{
	private BusinessDelegate sistema;
	
	private JLabel JLdni;
	private JTextField JTdni;
	
	private JButton JBDarBaja;
	private JButton JBCancelar;
	
	private GridLayout gl;

	public BajaCliente() {
		super();
		sistema = BusinessDelegate.getInstance();
		iniGUI();
	}
	
	public void iniGUI(){
		try {
			
			gl = new GridLayout(2, 2);
			gl.setVgap(10);
			this.setTitle("Baja de Cliente");
			this.setLayout(gl);
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setSize(200, 100);
			this.setLocationRelativeTo(null);
			
			
			JLdni = new JLabel("DNI:");
			JTdni = new JTextField(20);
			
			
			JBDarBaja=new JButton("Dar Baja");
			JBCancelar = new JButton("Cancelar");
			
			getContentPane().add(JLdni);
			getContentPane().add(JTdni);
			getContentPane().add(JBDarBaja);
			getContentPane().add(JBCancelar);
			
			
			
			JBDarBaja.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					sistema.bajaCliente(Integer.parseInt(JTdni.getText()));
					
				}
			});
			
			JBCancelar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
			});
			
			this.setVisible(true);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public static void main(String[] args) {
		BajaCliente bj = new BajaCliente();
	}
	
	
}
