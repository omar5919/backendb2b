package com.incloud.tgestiona.b2b.servicesImpl;

import org.springframework.stereotype.Service;
import com.incloud.tgestiona.b2b.model.Moneda;
import com.incloud.tgestiona.framework.servicesImpl.JPACustomRepository;

@Service
public class MonedaServiceImpl extends JPACustomRepository<Moneda, Integer> {

}
