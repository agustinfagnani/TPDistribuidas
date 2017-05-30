package gui.ABMclientes;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import businessDelegate.BusinessDelegate;


public class AltaCliente extends JFrame {
	
	private BusinessDelegate sistema;
	
	private JLabel JLnroCliente;		private JTextField JTnroCliente;
	private JLabel JLnombre;	private JTextField JTnombre;

	private JLabel JLcuit;	private JTextField JTcuit;
	private JLabel JLlimite;	private JTextField JTlimite;
	private JLabel JLcondiciones;		private JTextField JTcondiciones;
	private JLabel JLnroSucursal;		private JTextField JTnroSucursal;
	
	
	
	private JButton JBconfirmar;
	private JButton JBcancelar;
	
	private GridLayout gl;
	
	public AltaCliente()  {
		super();
		sistema = BusinessDelegate.getInstance();
		iniGUI();
	}
	
	
	//quitarMain
	public static void main(String[] args) {
		AltaCliente ac = new AltaCliente();
	} 
	
	
	public void iniGUI(){
		try {
			gl = new GridLayout(7,2);
			
			this.setTitle("Alta de Cliente");
			this.setLayout(gl);
			this.setSize(400, 200);
			this.setLocationRelativeTo(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
			JLnroCliente = new JLabel ("Nº Cliente:");
			JLnombre = new JLabel("Nombre:");
			JLcuit = new JLabel("CUIT:");
			JLlimite = new JLabel("Limite de credito:");
			JLcondiciones = new JLabel("Condiciones de pago:");
			JLnroSucursal = new JLabel("Nº Sucursal:");
			
			JTnombre = new JTextField(20);
			JTnroCliente = new JTextField(20);
			JTcuit = new JTextField(20);
			JTlimite = new JTextField(20);
			JTcondiciones = new JTextField(20);
			JTnroSucursal = new JTextField(20);
			
			JBconfirmar = new JButton("Confirmar");
			JBcancelar = new JButton("Cancelar");
			
			getContentPane().add(JLnroCliente);		getContentPane().add(JTnroCliente);
			getContentPane().add(JLnombre);			getContentPane().add(JTnombre);
			
			getContentPane().add(JLcuit);			getContentPane().add(JTcuit);
			getContentPane().add(JLlimite);			getContentPane().add(JTlimite);
			getContentPane().add(JLcondiciones);	getContentPane().add(JTcondiciones);
			getContentPane().add(JLnroSucursal);	getContentPane().add(JTnroSucursal);
			getContentPane().add(JBconfirmar);		getContentPane().add(JBcancelar);
			
			
			JBconfirmar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					try{
					String nombre=JTnombre.getText();
					int nroCliente=Integer.parseInt(JTnroCliente.getText());
					
					String cuit=JTcuit.getText();
					
					float limite=Float.parseFloat(JTlimite.getText());
					String condiciones=JTcondiciones.getText();
					int nroSucursal = Integer.parseInt(JTnroSucursal.getText());
					
					sistema.altaCliente(nroCliente, nombre, cuit, limite, condiciones, nroSucursal);
					
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, "verifique que los datos esten ingresados correctamente","Error",JOptionPane.ERROR_MESSAGE);
					}
				
				}
			});
			
			JBcancelar.addActionListener(new ActionListener() {
				
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
	
	
	
	
	
}
