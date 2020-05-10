package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.Usuarios;
import com.incloud.tgestiona.b2b.repository.SeguridadRepository;
import com.incloud.tgestiona.b2b.service.dto.usuarioInDto;
import com.incloud.tgestiona.b2b.servicesImpl.SeguridadServiceImpl;
import com.incloud.tgestiona.framework.JPACustomRest;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/seguridad")
//@CrossOrigin(origins = "http://localhost:4200")
public class SeguridadRest extends JPACustomRest<Usuarios, Integer> {

	private final Logger log = LoggerFactory.getLogger(OfertaRest.class);

	@Autowired
	protected SeguridadServiceImpl seguridadService;

	@Autowired
	private SeguridadRepository<Usuarios> uRepo;

	@ApiOperation(value = "Valida las credenciales del usuario si existe en bd", produces = "application/json")
	@RequestMapping(value = "/autenticacion", method = RequestMethod.POST, headers = "Accept=application/json")
	public Usuarios autenticacion(@RequestBody @Valid usuarioInDto e, BindingResult bindingResult) throws Exception {
		Usuarios u = uRepo.findFirstByUsuario(e.getUsuario());
		if (u != null) {
			u = uRepo.findFirstByUsuarioAndClave(e.getUsuario(), e.getClave());
			if (u != null) {
				u = uRepo.findFirstByUsuarioAndClaveAndActivo(e.getUsuario(), e.getClave(), 1);
				if (u != null) {
					u.setMensaje("USUARIO PERMITIDO");
					u.setNombrecorto(
							String.valueOf(u.getNombres().charAt(0)) + String.valueOf(u.getApellidos().charAt(0)));
					return u;
				} else {
					u = new Usuarios();
					u.setMensaje("EL USUARIO NO SE ENCUENTRA ACTIVO");
				}
			} else {
				u = new Usuarios();
				u.setMensaje("LA CLAVE ES INCORRECTA");
			}
		} else {
			u = new Usuarios();
			u.setMensaje("USUARIO NO EXISTE");
		}
		
		return u;
	}

	@ApiOperation(value = "Valida las credenciales del usuario si existe en bd", produces = "application/json")
	@RequestMapping(value = "/cambioclave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Usuarios cambioclave(@RequestBody @Valid usuarioInDto e, BindingResult bindingResult) throws Exception {
		Usuarios res = new Usuarios();
		var u = uRepo.findById(e.getId());
		if (u.isPresent()) {
			Usuarios us = u.get();
			if (us.getClave().equalsIgnoreCase(e.getPasswordActual())) {
				us.setClave(e.getConfirmPassword());
				res = uRepo.save(us);
				res.setMensaje("LA CLAVE SE CAMBIO CORRECTAMENTE... DEBE DE SALIR...");
			} else {
				res.setMensaje("LA CLAVE ACTUAL NO COINCIDE...");
			}
		}
		return res;
	}

}