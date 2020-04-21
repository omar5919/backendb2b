package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.MedioAcceso;

@Component
public interface MedioAccesoService {

	public List<?> getAll();

	public Optional<?> findByID(Integer id);

	public List<MedioAcceso> saveAll(List<MedioAcceso> entities);

	public MedioAcceso save(MedioAcceso entities);

	public MedioAcceso deleteById(Integer id);

	public MedioAcceso deleteAll();

}
