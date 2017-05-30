package modelo;

import java.util.List;

import Exceptions.TalleYColorException;
import dto.PrendaDTO;

public class Prenda {
	
	private int codPrenda;
	private int descricpion;
	private float costoProduccion;
	private boolean enActualProduccion;
	private List<TalleYColor> tallesYColores;
	private float porcentajeGanancia;
	private List areas;
	private String temporada;
	
	public PrendaDTO getView(){
		
		PrendaDTO prendaView = new PrendaDTO(codPrenda, descricpion, costoProduccion, enActualProduccion, porcentajeGanancia, temporada);
		for (TalleYColor item : tallesYColores) {
			prendaView.addTalleYColor(item.getView());
		}
	
		return prendaView;
	}
	
	public boolean sosPrenda(int codPrenda){
		return this.codPrenda==codPrenda;
	}
	
	public TalleYColor getTalleYColor(String talle,String color) throws TalleYColorException{
		for (TalleYColor item : tallesYColores) {
			if(item.sosTalleYColor(talle, color)){
				return item;
			}
			
		}
		throw new TalleYColorException("el talle: "+talle+" con el color:"+color+" no existen en prenda"+codPrenda);
		
	}
	
	
}
