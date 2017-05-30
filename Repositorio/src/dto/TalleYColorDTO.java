package dto;

import java.util.List;



public class TalleYColorDTO {

	private String talle;
	private String color;
	private List insumos;
	private int cantidadFabricacion;
	private String molde;
//	private OrdenProduccion lote;
	public TalleYColorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TalleYColorDTO(String talle, String color, int cantidadFabricacion,
			String molde) {
		super();
		this.talle = talle;
		this.color = color;
		this.cantidadFabricacion = cantidadFabricacion;
		this.molde = molde;
	}
	public String getTalle() {
		return talle;
	}
	public void setTalle(String talle) {
		this.talle = talle;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public List getInsumos() {
		return insumos;
	}
	public void setInsumos(List insumos) {
		this.insumos = insumos;
	}
	public int getCantidadFabricacion() {
		return cantidadFabricacion;
	}
	public void setCantidadFabricacion(int cantidadFabricacion) {
		this.cantidadFabricacion = cantidadFabricacion;
	}
	public String getMolde() {
		return molde;
	}
	public void setMolde(String molde) {
		this.molde = molde;
	}
	
	
	
}
