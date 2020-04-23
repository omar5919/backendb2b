package com.incloud.tgestiona.b2b.serices;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.Usuarios;

@Component
public interface SeguridadService {
	
	public Optional<Usuarios> autenticacion(Usuarios u);	
	public Optional<Usuarios> findByCredenciales(String usuario,String clave);
	
}
