package com.incloud.tgestiona.b2b.servicesImpl;

import org.springframework.stereotype.Service;
import com.incloud.tgestiona.b2b.model.Usuarios;
import com.incloud.tgestiona.framework.servicesImpl.JPACustomRepository;

@Service("SeguridadServiceImpl")
public class SeguridadServiceImpl extends JPACustomRepository<Usuarios, Integer> {

}
