package com.incloud.tgestiona.b2b.serices;

import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.ofertaDto;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface OfertasService {

    BaseBandejaResponse<List<ofertaDto>> getOfertas(String codoportunidad,String cliente,String descripcion, Integer complejidad,Integer estado,Date desde, Date hasta, Pageable pageable);

    void addOferta(ofertaDto student);
}
