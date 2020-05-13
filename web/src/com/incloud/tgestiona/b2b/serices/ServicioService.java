package com.incloud.tgestiona.b2b.serices;

import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.distritoDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicioService {
    BaseBandejaResponse<List<distritoDto>> obtenerdistrito(String search, Pageable pageable);
}
