package com.incloud.tgestiona.b2b.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.incloud.tgestiona.b2b.model.Usuarios;
import com.incloud.tgestiona.b2b.repository.SeguridadRepository;
import com.incloud.tgestiona.b2b.serices.SeguridadService;

@Service("SeguridadServiceImpl")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SeguridadServiceImpl implements SeguridadService {

	@Autowired
	private SeguridadRepository<Usuarios> usuarioRepository;

	@Transactional
	public Optional<Usuarios> autenticacion(Usuarios u) {
		// return usuarioRepository.findByUsuarioyClave(u.getUsuario(), u.getClave());
		return usuarioRepository.findById(1);
	}

	@Override
	@Transactional
	public Optional<Usuarios> findByCredenciales(String usuario, String clave) {

		Usuarios user = new Usuarios();
		user.setUsuario(usuario);
		user.setClave(clave);

		Example<Usuarios> employeeExample = Example.of(user);
		return usuarioRepository.findOne(employeeExample);
		/// return (Optional<Usuarios>)
		/// usuarioRepository.findByCredenciales(usuario,clave);
	}

}
