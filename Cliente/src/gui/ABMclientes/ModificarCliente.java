package gui.ABMclientes;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;

public class ModificarCliente extends JFrame {
	private BusinessDelegate sistema;
	
	private JLabel JLnroCliente;
	private JLabel JLnombre;
	private JLabel JLcuit;
	private JLabel JLlimite;
	private JLabel JLcondiciones;
	private JLabel JLnroSucursal;
	
	private JTextField JTnroCliente;
	private JTextField JTnombre;
	private JTextField JTcuit;
	private JTextField JTlimite;
	private JTextField JTcondiciones;
	private JTextField JTnroSucursal;

	private JButton buscar;
	private JButton guardar;
	private JButton cancelar;
	
	private JPanel p1;
	private JPanel p2;
	
	private int alto;
	private int largo;
	
	
	public ModificarCliente() throws HeadlessException {
		super();
		sistema = BusinessDelegate.getInstance();
		alto = 300;
		largo = 400;
		
		
		iniGUI();
		
	}

	public void iniGUI(){
		getContentPane().setLayout(null);
		
		this.setTitle("Modificacion de Cliente");
		this.setSize(largo,alto);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		//============Configuraciones de los paneles===============
		p1 = new JPanel(new GridLayout(1,3));
		p1.setSize(largo, 30);
		
		
		p2 = new JPanel(new GridLayout(7,2));
		p2.setSize(largo, alto-35);
		p2.setBounds(0,50, largo, alto-60);
		((GridLayout)p2.getLayout()).setVgap(5);
		//==========================================================
		
		
		//=======================================================================
		JLnroCliente = new JLabel("Nº Cliente:");				JTnroCliente= new JTextField(20);
		buscar = new JButton("Buscar");
		
		JLnombre = new JLabel("Nombre:");						JTnombre = new JTextField(20);
		JLcuit = new JLabel("CUIT:");							JTcuit = new JTextField(20);
		JLlimite = new JLabel("Limite de Credito:");			JTlimite = new JTextField(20);
		JLcondiciones = new JLabel("Condiciones de pago:");		JTcondiciones = new JTextField(20);
		JLnroSucursal = new JLabel("Nº Sucursal");				JTnroSucursal = new JTextField(20);
		
		guardar = new JButton("Guardar");		cancelar = new JButton("Cancelar");
		
		
		//========================================================================
		
		
		
		//construccion de los paneles de la pantalla
		p1.add(JLnroCliente);	p1.add(JTnroCliente);	p1.add(buscar);
		
		p2.add(JLnombre);		p2.add(JTnombre);
		p2.add(JLcuit);			p2.add(JTcuit);
		p2.add(JLlimite);		p2.add(JTlimite);
		p2.add(JLcondiciones);	p2.add(JTcondiciones);
		p2.add(JLnroSucursal);	p2.add(JTnroSucursal);
		
		p2.add(guardar);		p2.add(cancelar);
		
		
		
		getContentPane().add(p1);
		getContentPane().add(p2);
		
		p2.setVisible(false);		
		this.setVisible(true);
		
		
		
		buscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClienteDTO clienteView;
				try {
					clienteView = sistema.obtenerCliente(Integer.parseInt(JTnroCliente.getText()));
					JTnroCliente.setEnabled(false);
					JTnombre.setText(clienteView.getNombre());
					JTcuit.setText(clienteView.getCuit());
					JTlimite.setText(Float.toString(clienteView.getCtacte().getLimite()));
					JTcondiciones.setText(clienteView.getCtacte().getCondiciones());
					JTnroSucursal.setText(Integer.toString(clienteView.getNroSucursal()));
					
					p2.setVisible(true);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					
				}
				
				
			}
		});
		
		guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ClienteDTO clienteView = new ClienteDTO();
				
				clienteView.setNombre(JTnombre.getText());
				clienteView.setCuit(JTcuit.getText());
				clienteView.getCtacte().setLimite(Float.parseFloat(JTlimite.getText()));
				clienteView.getCtacte().setCondiciones(JTcondiciones.getText());
				clienteView.setNroSucursal(Integer.parseInt(JTnroSucursal.getText()));
				

				try {
					sistema.modificarCliente(clienteView);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
				JTnroCliente.setEnabled(true);
				p2.setVisible(false);
			}
		});
		
		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
		
	}
	
	public static void main(String[] args) {
		ModificarCliente md= new ModificarCliente();
	}
	
	
}
