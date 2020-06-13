package co.edu.ufps.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.ufps.model.Pelicula;
import co.edu.ufps.service.IPeliculasService;
import co.edu.ufps.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IPeliculasService servicePeliculas;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome() {
		return"home";
	}
	
	//@RequestMapping(value="/search",method=RequestMethod.POST)
	@PostMapping (value="/search")
	public String buscar(@RequestParam("fecha") String fecha, Model model) {
		List<String> listaFechas = Utileria.getNextDays(4);
		System.out.println(listaFechas);
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		System.out.println("Buscando por fecha"+ fecha);
		return "home";
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<String> listaFechas = Utileria.getNextDays(4);
		System.out.println(listaFechas);
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
//		peliculas.add("Rapido y Furioso");
//		peliculas.add("Alita");
//		peliculas.add("El Hombre Invisible");
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		return"home";
	}
	
//	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
	@RequestMapping(value="/detail", method=RequestMethod.GET)
//	public String mostrarDetalle(Model model,@PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha){	
	public String mostrarDetalle(Model model,@RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha){	
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		System.out.println("Buscando Horarios para la Pelicula: "+ idPelicula);
		System.out.println("Para la fecha: "+ fecha);
//		String tituloPelicula="Rapido y furioso 9";
//		int duracion= 150;
//		double precioEntrada =50;
//		model.addAttribute("titulo", tituloPelicula);
//		model.addAttribute("duracion", duracion);
//		model.addAttribute("precio", precioEntrada);
		return "detalle";
		
	}
//	private List<Pelicula> getLista(){
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
//		List<Pelicula>lista = null;
//		
//		try {
//			lista = new LinkedList<>();
//			Pelicula pelicula1 = new Pelicula();
//			pelicula1.setId(1);
//			pelicula1.setTitulo("Sonic");
//			pelicula1.setDuracion(120);
//			pelicula1.setClasificacion("B");
//			pelicula1.setGenero("Animada");		
//			pelicula1.setFechaestreno(formatter.parse("11-06-2020"));
//			
//			Pelicula pelicula2 = new Pelicula();
//			pelicula2.setId(2);
//			pelicula2.setTitulo("Rapido y Furioso");
//			pelicula2.setDuracion(150);
//			pelicula2.setClasificacion("A");
//			pelicula2.setGenero("Acción");		
//			pelicula2.setFechaestreno(formatter.parse("18-06-2020"));
//			pelicula2.setImagen("rapido.png");
//			
//			Pelicula pelicula3 = new Pelicula();
//			pelicula3.setId(3);
//			pelicula3.setTitulo("Avatar");
//			pelicula3.setDuracion(160);
//			pelicula3.setClasificacion("C");
//			pelicula3.setGenero("Aventura");		
//			pelicula3.setFechaestreno(formatter.parse("18-06-2020"));
//			pelicula3.setImagen("avatar.png");
//			
//			Pelicula pelicula4 = new Pelicula();
//			pelicula4.setId(3);
//			pelicula4.setTitulo("Frozen II");
//			pelicula4.setDuracion(160);
//			pelicula4.setClasificacion("B");
//			pelicula4.setGenero("Animada");		
//			pelicula4.setFechaestreno(formatter.parse("18-06-2020"));
//			pelicula4.setImagen("frozen.jpg");
//			pelicula4.setEstatus("Inactiva");
//			
//			lista.add(pelicula1);
//			lista.add(pelicula2);
//			lista.add(pelicula3);
//			lista.add(pelicula4);
//			return lista;
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Error: "+ e.getMessage());
//			return null;
//		}
//		
//		
//		
//	}
	
}
