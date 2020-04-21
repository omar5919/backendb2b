package com.incloud.tgestiona.b2b.serices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.incloud.tgestiona.b2b.model.ContactoSede;

@Component
public interface ContactoSedeService {

	public List<ContactoSede> getAll();

	public Optional<ContactoSede> findByID(Integer id);

	public List<ContactoSede> saveAll(List<ContactoSede> entities);

	public ContactoSede save(ContactoSede entities);

	public ContactoSede deleteById(Integer id);

	public ContactoSede deleteAll();

}
