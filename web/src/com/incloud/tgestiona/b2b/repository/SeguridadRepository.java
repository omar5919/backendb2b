package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incloud.tgestiona.b2b.model.Usuarios;

public interface SeguridadRepository<P> extends JpaRepository<Usuarios, Integer> {
	Usuarios findFirstByUsuario(String usuario);
	Usuarios findFirstByUsuarioAndClave(String usuario,String clave);
	Usuarios findFirstByUsuarioAndClaveAndActivo(String usuario,String clave,int activo);
}
