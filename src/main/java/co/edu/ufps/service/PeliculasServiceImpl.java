package co.edu.ufps.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.ufps.model.Pelicula;

@Service
public class PeliculasServiceImpl implements IPeliculasService{
	
	private List<Pelicula>lista = null;
	
	
	public PeliculasServiceImpl() {
		System.out.println("Creando una clase blblabla");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		
		
		try {
			lista = new LinkedList<>();
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Sonic");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Animada");		
			pelicula1.setFechaestreno(formatter.parse("11-06-2020"));
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("Rapido y Furioso");
			pelicula2.setDuracion(150);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Acción");		
			pelicula2.setFechaestreno(formatter.parse("18-06-2020"));
			pelicula2.setImagen("rapido.png");
			
			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Avatar");
			pelicula3.setDuracion(160);
			pelicula3.setClasificacion("C");
			pelicula3.setGenero("Aventura");		
			pelicula3.setFechaestreno(formatter.parse("18-06-2020"));
			pelicula3.setImagen("avatar.png");
			
			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(3);
			pelicula4.setTitulo("Frozen II");
			pelicula4.setDuracion(160);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Animada");		
			pelicula4.setFechaestreno(formatter.parse("18-06-2020"));
			pelicula4.setImagen("frozen.jpg");
			pelicula4.setEstatus("Inactiva");
			
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+ e.getMessage());
			
		}
	}
	@Override
	public List<Pelicula> buscarTodas() {
		
		return lista;
	}
	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for (Pelicula p : lista) {
			if(p.getId()==idPelicula) {
				return p;
			}
		}
		return null;
	}
	@Override
	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);
		
	}

}
