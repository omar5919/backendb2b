package com.incloud.tgestiona.b2b.servicesImpl;

import org.springframework.stereotype.Service;
import com.incloud.tgestiona.b2b.model.Usuarios;

@Service("SeguridadServiceImpl")
public class SeguridadServiceImpl extends JPACustomRepository<Usuarios, Integer> {

}
