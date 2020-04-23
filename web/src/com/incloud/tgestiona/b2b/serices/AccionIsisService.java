package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.AccionIsis;

@Component
public interface AccionIsisService {

	public List<AccionIsis> getAll();

	public Optional<AccionIsis> findByID(Integer id);

	public List<AccionIsis> saveAll(List<AccionIsis> entities);

	public AccionIsis save(AccionIsis entities);
	//public <T> T save(T dto) throws Exception ;

	public AccionIsis deleteById(Integer id);

	public AccionIsis deleteAll();
}
