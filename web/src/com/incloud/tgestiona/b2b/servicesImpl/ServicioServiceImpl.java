package com.incloud.tgestiona.b2b.servicesImpl;

import com.incloud.tgestiona.b2b.repository.OfertasRepository;
import com.incloud.tgestiona.b2b.repository.ServicioRepository;
import com.incloud.tgestiona.b2b.serices.ServicioService;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.distritoDto;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository sRepo;

    public ServicioServiceImpl(ServicioRepository sRepo) {
        this.sRepo = sRepo;
    }

    @Override
    public BaseBandejaResponse<List<distritoDto>> obtenerdistrito(String search, Pageable pageable) {
        return null;
    }
}
