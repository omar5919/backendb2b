package com.incloud.tgestiona.b2b.serices;

import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.service.dto.ofertaDto;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface OfertasService {

    List<ofertaDto> getOfertas(Date fromDate, Date toDate, String name, Pageable pageable);

    void addOferta(ofertaDto student);
}
