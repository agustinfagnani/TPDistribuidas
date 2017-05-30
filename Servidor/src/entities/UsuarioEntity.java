package entities;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "usuarios")
public class UsuarioEntity {
	
	@Id
	private int id;
	private String nombre;
	public UsuarioEntity(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	
	
}
