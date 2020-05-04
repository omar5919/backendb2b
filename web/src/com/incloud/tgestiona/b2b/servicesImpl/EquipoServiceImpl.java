package com.incloud.tgestiona.b2b.servicesImpl;

import com.incloud.tgestiona.b2b.model.isis.IsisEquipo;
import org.springframework.stereotype.Service;

import com.incloud.tgestiona.framework.servicesImpl.JPACustomRepository;

@Service
public class EquipoServiceImpl extends JPACustomRepository<IsisEquipo, Integer> {

}
