package dto;

import java.util.List;



public class PrendaDTO {
	
	private int codPrenda;
	private int descricpion;
	private float costoProduccion;
	private boolean enActualProduccion;
	private List<TalleYColorDTO> tallesYColores;
	private float porcentajeGanancia;
	private List areas;
	private String temporada;
	
	
	
	
	
	public PrendaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PrendaDTO(int codPrenda, int descricpion, float costoProduccion,
			boolean enActualProduccion, float porcentajeGanancia,
			String temporada) {
		super();
		this.codPrenda = codPrenda;
		this.descricpion = descricpion;
		this.costoProduccion = costoProduccion;
		this.enActualProduccion = enActualProduccion;
		this.porcentajeGanancia = porcentajeGanancia;
		this.temporada = temporada;
	}
	public int getCodPrenda() {
		return codPrenda;
	}
	public void setCodPrenda(int codPrenda) {
		this.codPrenda = codPrenda;
	}
	public int getDescricpion() {
		return descricpion;
	}
	public void setDescricpion(int descricpion) {
		this.descricpion = descricpion;
	}
	public float getCostoProduccion() {
		return costoProduccion;
	}
	public void setCostoProduccion(float costoProduccion) {
		this.costoProduccion = costoProduccion;
	}
	public boolean isEnActualProduccion() {
		return enActualProduccion;
	}
	public void setEnActualProduccion(boolean enActualProduccion) {
		this.enActualProduccion = enActualProduccion;
	}
	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}
	public void setPorcentajeGanancia(float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}

	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	
	public void addTalleYColor(TalleYColorDTO talleYColor){
		tallesYColores.add(talleYColor);
		
	}
	
	
	
	
}
