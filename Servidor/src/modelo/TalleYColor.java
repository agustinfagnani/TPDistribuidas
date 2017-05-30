package modelo;

import java.util.List;

import dto.TalleYColorDTO;

public class TalleYColor {
	
	private String talle;
	private String color;
	private List insumos;
	private int cantidadFabricacion;
	private String molde;
	private OrdenProduccion lote;
	
	public TalleYColorDTO getView(){
		TalleYColorDTO talleYColorView = new TalleYColorDTO(talle, color, cantidadFabricacion, molde);
		//hace falta poner insumos?
		
		return talleYColorView;
	}
	
	public boolean sosTalleYColor(String talle,String color){
		return this.talle==talle && this.color == color;
	}
	
}
