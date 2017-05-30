package dto;

public class ItemPrendaDTO {
	
	private PrendaDTO prenda;
	private TalleYColorDTO talleYColor;
	private int cantidad;
	public PrendaDTO getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaDTO prenda) {
		this.prenda = prenda;
	}
	public TalleYColorDTO getTalleYColor() {
		return talleYColor;
	}
	public void setTalleYColor(TalleYColorDTO talleYColor) {
		this.talleYColor = talleYColor;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
}
