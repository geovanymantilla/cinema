package co.edu.ufps.service;

import java.util.List;

import co.edu.ufps.model.Pelicula;

public interface IPeliculasService {
	void insertar(Pelicula pelicula);
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
	

}
