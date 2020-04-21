package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.SegmentoNegocio;

@Component
public interface SegmentoNegocioService {

	public List<SegmentoNegocio> getAll();

	public Optional<SegmentoNegocio> findByID(Integer id);

	public List<SegmentoNegocio> saveAll(List<SegmentoNegocio> entities);

	public SegmentoNegocio save(SegmentoNegocio entities);

	public SegmentoNegocio deleteById(Integer id);

	public SegmentoNegocio deleteAll();

}
