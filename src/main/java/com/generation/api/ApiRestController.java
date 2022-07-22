package com.generation.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.models.Usuario;
import com.generation.models.Auto;
import com.generation.models.Cliente;
import com.generation.services.AutoService;
import com.generation.services.ClienteService;
import com.generation.services.UsuarioService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ApiRestController {
	
	@Autowired //inyeccion de dependencia de clase
	AutoService autoService;
	
	@Autowired
	UsuarioService  uService;
	
	@Autowired
	ClienteService cService;
	
	//localhost:8080/api/obtener/autos
	@RequestMapping("/obtener/autos")
	public List<Auto> obtenerListaAutos(){
		List<Auto> listaAutos = autoService.findAll();
		return listaAutos;
		
	}
	
	//API (JSON)
	@PostMapping(value="/guardar/auto")
	public ResponseEntity<Auto> guardarAuto(@RequestBody Auto auto){
		autoService.guardarAuto(auto);
		return new ResponseEntity<Auto>(auto,null, HttpStatus.CREATED);
	}
	
	@PostMapping(value="/eliminar/auto/{id}")
	public ResponseEntity<Auto> eliminarAuto(@PathVariable Long id){
		try {
			autoService.eliminarPorId(id);
			return new ResponseEntity<Auto>( HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Auto>( HttpStatus.NOT_MODIFIED);
		}
		
	}
	
	@RequestMapping(value = "/usuarios/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Usuario> getUsuarios(HttpServletRequest request){
		List<Usuario> usuarios = uService.findAll();
		return usuarios;
	}
	
	@RequestMapping(value = "/clientes/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Cliente> findAll(HttpServletRequest request){
		List<Cliente> clientes = cService.findAll();
		return clientes;
	}
}
