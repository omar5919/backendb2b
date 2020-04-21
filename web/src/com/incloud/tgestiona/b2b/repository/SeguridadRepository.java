package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incloud.tgestiona.b2b.model.Usuarios;

public interface SeguridadRepository<P> extends JpaRepository<Usuarios, Integer> {

//	@Query(value = "SELECT * FROM seguridad.usuarios u where u.usuario = ?1 and u.clave = ?2", nativeQuery = true)
	// Optional<Usuarios> findByCredenciales(String usuario,String clave);

}
