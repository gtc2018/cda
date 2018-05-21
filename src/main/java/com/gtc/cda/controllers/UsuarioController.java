package com.gtc.cda.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtc.cda.common.FormatoFecha;
import com.gtc.cda.models.Empleado;
import com.gtc.cda.models.Empresa;
import com.gtc.cda.models.Fase;
import com.gtc.cda.models.Rol;
import com.gtc.cda.models.Usuario;
import com.gtc.cda.services.EmpleadoService;
import com.gtc.cda.services.EmpresaService;
import com.gtc.cda.services.RolService;
import com.gtc.cda.services.UsuarioService;
import com.gtc.cda.util.RestResponse;

/**DOCUMENTACION 
 * 
 * @author Dirección Calidad
 *
 */

@CrossOrigin(origins="*")

@RestController
public class UsuarioController {
	
	@Autowired
	protected UsuarioService usuarioService;
	
	@Autowired
	protected EmpleadoService empleadoService;
	@Autowired
	protected EmpresaService empresaService;
	@Autowired
	protected RolService rolService;
	
	protected ObjectMapper mapper;
	
	
	/**
	 * Método crear o actualizar Usuarios.
	 * @param usuarioJson
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException 
	 */
	@RequestMapping(value ="/saveOrUpdateUsuario", method = RequestMethod.POST)
	public RestResponse saveOrUpdateUsuario(@RequestBody String usuarioJson) throws JsonParseException, JsonMappingException, IOException, ParseException{
		
		this.mapper = new ObjectMapper();
		
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		
		if (!this.validate(usuario)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		
		//Generacion fecha creacion
				FormatoFecha fecha = new FormatoFecha();
				Date fech = new Date();
				//seteo la fecha de creacion al campo fechaCreacion.
				if(usuario.getId() ==null ) {
					usuario.setFechaCreacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
					usuario.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));
				}
				else {
				//Seteo la fecha de modificacion al campo fechaModificacion.
					usuario.setFechaModificacion(fecha.fecha("yyyy-MM-dd HH:mm:ss", fech));	
				}
				
				//Valida la entrada de los datos por estructura
				if (usuario.getClienteId() != null | usuario.getEmpleadoId() != null
						| usuario.getRolId() != null) {
				
				    Empresa empresa = new Empresa();// Variable de empresa
			        
			        Empleado empleado = new Empleado();//Variable de empleado
			        
			        Rol rol = new Rol();// Variable de rol
					
					empresa.setId(new Long(usuario.getClienteId()));// Setea el id que viene del campo ClienteId a la variable empresa
					
					empleado.setId(new Long(usuario.getEmpleadoId()));// Setea el id que viene del campo EmpleadoId a la variable empleado
					
					rol.setId(new Long(usuario.getRolId()));// Setea el id que viene del campo RolId a la variable rol
					
					usuario.setEmpleado(empleado);//Setea el empleado al usuario
					
					usuario.setRol(rol);;//Setea el rol al usuario
					
					usuario.setCliente(empresa);//Setea la empresa al usuario
					
					this.usuarioService.save(usuario);// Ejecuta el servicio para guardar el arreglo

					return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa"); // Se retorna una respuesta exitosa
					
				}else {
		
					this.usuarioService.save(usuario);
	
					return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
				}
	}
	
	
	/**
	 * Método consultar todos los usuarios.
	 * @return
	 */
	@RequestMapping(value ="/getAllUsuarios", method = RequestMethod.GET)
	public List<Usuario> getAllUsuarios(){
		
		return  this.usuarioService.findAll();
		
		
		
	}
	
	
	// CODIGO DE SANTIAGO --------------------------------------------------------
//	/**
//	 * Método consultar todos los usuarios.
//	 * @return
//	 */
//	@RequestMapping(value ="/getAllUsuarios", method = RequestMethod.GET)
//	public List<Usuario> getAllUsuarios(){
//		
//		List<Usuario> usuarios ;
//		
//		usuarios = this.usuarioService.findAll();
//		
//		for(Usuario usuario:usuarios){
//			
//			usuario.setNombres(this.empleadoService.getOne(usuario.getEmpleadoId()).getNombres());
//			
//			usuario.setApellidos(this.empleadoService.getOne(usuario.getEmpleadoId()).getApellidos());
//			
//			usuario.setCliente(this.empresaService.getOne(new Long(usuario.getClienteId())).getDescripcion());
//			
//			usuario.setRol(this.rolService.getOne(new Long(usuario.getRolId())).getDescripcion());
//		}
//	  
//		return  usuarios;
//		
//		
//		
//	}
	
	
	
	/**
	 * Método eliminar usuario.
	 * @param usuarioJson
	 * @throws Exception
	 */
	@RequestMapping(value ="/deleteUsuario", method = RequestMethod.POST)
	public void deleteUsuario(@RequestBody String usuarioJson) throws Exception{
		this.mapper = new ObjectMapper();
		
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		
		if(usuario.getId() == null){
			throw new Exception("El ID no puede ser nulo.");
		}
		
		this.usuarioService.deleteUsuario(usuario.getId());
		
	}
	
	/**
	 * 
	 * @param permisoJson
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getAllUsuariosByEmpresaId", method = RequestMethod.POST)
	public List<Usuario>  getAllUsuariosByEmpresaId(@RequestBody String usuarioJson) throws Exception {

		this.mapper = new ObjectMapper();
			
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		
		return this.usuarioService.findByEmpresaId(usuario.getClienteId());

	}
	
	@RequestMapping(value = "/getAUsuariosById", method = RequestMethod.POST)
	public Usuario  getUsuariosById(@RequestBody String usuarioJson) throws Exception {

		this.mapper = new ObjectMapper();
			
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		
		return this.usuarioService.findByUsuarioId(usuario.getEmail(), usuario.getPassword());

	}
	
	
	
	
	
	/**
	 * Método validar parametros de entrado creacion usuario.
	 * @param usuario
	 * @return
	 */
	private boolean validate(Usuario usuario) {
	
		boolean isValid = true;
		
		if (StringUtils.trimToNull(usuario.getEmail()) == null ) {

			isValid = false;

		}
		
		if (StringUtils.trimToNull(usuario.getPassword()) == null ) {

			isValid = false;

		}
		
		return isValid;
		
	}
	

}
