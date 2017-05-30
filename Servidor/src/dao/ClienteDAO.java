package dao;


import hbt.HbSessionFactory;
import java.util.List;
import modelo.Cliente;
import org.hibernate.Session;
import Exceptions.ClienteNoExisteException;
import entities.ClienteEntity;

//convierte tambien de clientes entities a clientes de negocio y viceversa

public class ClienteDAO {
	
	private static ClienteDAO instance=null;
	
	public static ClienteDAO getinstance(){
		if(instance == null){
			instance = new ClienteDAO();
		}
		return instance;
	}
	
	private ClienteDAO(){
		super();
	}
	
	
	public void save(Cliente cliente){
		Session session = HbSessionFactory.getSessionFactory().openSession();
				
		session.beginTransaction();
		
		session.persist(instance.toEntity(cliente));
		
		session.flush();
		session.getTransaction().commit();
		session.close();
				
	}
	
	public Cliente findClienteByNroCliente(int nroCliente) throws ClienteNoExisteException{
		
		//en caso de no existir devuleve una exception
		
		throw new ClienteNoExisteException("El CLiente con el nro: "+ nroCliente+" no existe");
		
		//falta desarrollar
		
	}
	
	public void updateClientStatus(int nroCliente,boolean status){
		//cambiar el estado del cliente ya sea activo a inactivo o viceversa
	}
	
	public List<Cliente> findAllClientesActivos(){
		//devolver los clientes activos
		
		return null;
	}
	
	public void update(Cliente cliente){
		//actualizar los datos del cliente
		
	}
	
	
	
	public ClienteEntity toEntity(Cliente cliente){
		return new ClienteEntity(cliente.getNroCliente(), cliente.getNombre(), cliente.getCuit(), CuentaCorrienteDAO.getInstance().toEntity(cliente.getCtacte()), cliente.getNroSucursal(), cliente.isActivo());
		
	}
	
	
	public void pruebaSave(ClienteEntity cliente){
		Session session = HbSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.persist(cliente);
		
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	
}
