package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.incloud.tgestiona.b2b.model.oferta.OfertasCapex;
@Repository
public interface OfertasCapexRepository  extends JpaRepository<OfertasCapex, Integer>, JpaSpecificationExecutor<OfertasCapex>  {

}
