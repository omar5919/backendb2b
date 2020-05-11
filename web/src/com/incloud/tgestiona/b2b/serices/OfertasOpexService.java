package com.incloud.tgestiona.b2b.serices;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.OfertasOpexDto;

public interface OfertasOpexService {

	
    BaseBandejaResponse<List<OfertasOpexDto>> getOfertasOpex(Integer ofertaId, Pageable pageable);
}
