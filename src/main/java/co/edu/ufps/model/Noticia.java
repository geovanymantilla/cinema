package co.edu.ufps.model;

import java.util.Date;

public class Noticia {
	private int id;
	private String titulo;
	private Date fecha;
	private String detalle;
	private String estatus;
	
	public Noticia() {
		
		this.fecha= new Date();
		this.estatus= "Activa";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFeccha() {
		return fecha;
	}
	public void setFeccha(Date feccha) {
		this.fecha = feccha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", feccha=" + fecha + ", detalle=" + detalle + ", estatus="
				+ estatus + "]";
	}
	

}
