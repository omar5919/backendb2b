package com.incloud.tgestiona.b2b.servicesImpl;

import org.springframework.stereotype.Service;

import com.incloud.tgestiona.b2b.model.isis.Equipo;
import com.incloud.tgestiona.framework.servicesImpl.JPACustomRepository;

@Service
public class EquipoServiceImpl extends JPACustomRepository<Equipo, Integer> {

}
