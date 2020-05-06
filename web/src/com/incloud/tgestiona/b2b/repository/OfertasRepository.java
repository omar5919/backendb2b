package com.incloud.tgestiona.b2b.repository;

import com.incloud.tgestiona.b2b.model.Usuarios;
import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface OfertasRepository extends JpaRepository<Ofertas, Integer>, JpaSpecificationExecutor<Ofertas> {

	
	@Procedure("sp_copiar_oferta")
	int copiarOferta(Integer ofertaId,Integer usuarioId,String usuario);
	
	@Procedure("sp_anular_oferta")
	int anularOferta(Integer ofertaId,Integer usuarioId,String usuario);
	
	@Procedure("sp_versionar_oferta")
	int versionarOferta(Integer ofertaId,Integer usuarioId,String usuario);
}
