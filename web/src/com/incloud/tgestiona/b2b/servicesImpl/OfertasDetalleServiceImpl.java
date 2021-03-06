package com.incloud.tgestiona.b2b.servicesImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.JoinColumn;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.SetJoin;

import com.incloud.tgestiona.b2b.model.*;
import org.hibernate.sql.JoinType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.incloud.tgestiona.b2b.converter.ofertasConverter;
import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.model.oferta.OfertasDetalle;
import com.incloud.tgestiona.b2b.repository.OfertasDetalleRepository;
import com.incloud.tgestiona.b2b.serices.OfertasDetalleService;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.OfertasDetalleDto;

@Service
public class OfertasDetalleServiceImpl implements OfertasDetalleService {

    private final OfertasDetalleRepository oRepo;

    public OfertasDetalleServiceImpl(OfertasDetalleRepository oRepo) {
        this.oRepo = oRepo;
    }

    @Override
    public BaseBandejaResponse<List<OfertasDetalleDto>> getOfertasDetalle(Integer ofertaId, Pageable pageable) {
        Page<OfertasDetalle> pOfertasDetalle = oRepo.findAll((Specification<OfertasDetalle>) (root, cq, cb) -> {
            Predicate p = cb.conjunction();
            Join<OfertasDetalle, Ofertas> OfertasDetalleOfertas = root.join("ofertas");
            Join<OfertasDetalle, Cliente> OfertasDetalleCliente = root.join("cliente");
            Join<OfertasDetalle, Distrito> OfertasDetalleDistrito = root.join("distrito");

            //Join<OfertasDetalle, TipoServicio> OfertasDetalleTipoServicio = root.join("",JoinType.LEFT_OUTER_JOIN);
            if (!StringUtils.isEmpty(ofertaId)) p = cb.and(p, cb.equal(OfertasDetalleOfertas.get("oferta_id"), ofertaId));
            p = cb.and(p, cb.equal(root.get("activo"), true));
            cq.orderBy(cb.asc(root.get("ofertasDetalleId")));
            return p;
        }, pageable);
        return CargarDtoOfertaDetalle(pOfertasDetalle.getContent(), pOfertasDetalle.getTotalElements());//ofertasConverter.convertToOfertaDTO(pOfertas.getContent(),pOfertas.getTotalElements());
    }


    private BaseBandejaResponse<List<OfertasDetalleDto>> CargarDtoOfertaDetalle(List<OfertasDetalle> list, Long total) {
        BaseBandejaResponse<List<OfertasDetalleDto>> oDto = new BaseBandejaResponse<>();
        oDto.setMsj("200");
        oDto.setRows(total);
        List<OfertasDetalleDto> ol = list.stream().map(s ->
                OfertasDetalleDto.builder()
                        .ofertasDetalleId(s.getOfertasDetalleId())
                        .ofertaId(s.getOfertas().getId())
                        .clienteId(s.getCliente().getId())
                        .secuencia(s.getSecuencia())
                        .nombreSede(s.getNombreSede())
                        .nrotipoCircuitoActual(s.getNumero_circuito_actual())
                        .servicioActual_medio(s.getMedioactual() == null ? 0 :s.getMedioactual().getId())
                        .servicioActual_otro(s.getOtrosEquiposActual())
                        .servicioPropuesto_tiposede(s.getTipoenlace() == null ? 0 : s.getTipoenlace().getId())
                        .servicioPropuesto_modo(s.getCondicionenlace() == null ? 0 : s.getCondicionenlace().getId())
                        .servicioPropuesto_nrocircuito(s.getNumero_circuito_propuesto())
                        .servicioPropuesto_medio(s.getMediopropuesto() == null ? 0 : s.getMediopropuesto().getId())
                        .direccion(s.getDireccion())
                        .distritoId(s.getDistrito().getId())
                        .ubigeo(s.getUbigeo())
                        .latitud(s.getLatitud())
                        .longitud(s.getLongitud())
                        .zoom(s.getZoom())
                        .contacto(s.getContacto())
                        .telefono(s.getTelefono())
                        .condicion_servicio(s.getCondicion_servicio())
                        .tipoCircuitoActual(s.getTipocircuitoactual() == null ? 0 : s.getTipocircuitoactual().getId())
                        .numeroCdActual(s.getNumeroCdActual())
                        .tipoServicioIdActual((s.getTipoServicioActual() == null ? 0 : s.getTipoServicioActual().getId()))
                        .bwActualActual(s.getBwActualActual())
                        .caudalBronceActual(s.getCaudalBronceActual())
                        .caudal_plata_actual(s.getCaudal_plata_actual())
                        .caudalOroActual(s.getCaudalOroActual())
                        .caudalPlatinumActual(s.getCaudalPlatinumActual())
                        .caudalVozActual(s.getCaudalVozActual())
                        .caudalVideoActual(s.getCaudalVideoActual())
                        .caudalLdnActual(s.getCaudalLdnActual())
                        .ultimaMillaActual(s.getUltimaMillaActual())
                        .routerSwitchActual(s.getRouterSwitchActual())

                        .dteActual(s.getDteActual())
                        .recursoTransporteActual(s.getRecursoTransporteActual())
                        .tipoAntenaActual(s.getTipoAntenaActual())
                        .segmentoSatelitalActual(s.getSegmentoSatelitalActual())
                        .pozoTierraActual(s.getPozoTierraActual())
                        .upsActual(s.getUpsActual())
                        .vrf_actual(s.getVrf_actual())

                        .equipo_adicional_actual(s.getEquipo_adicional_actual())
                        .equipoTerminalActual(s.getEquipoTerminalActual())
                        .facturacion_actual(s.getFacturacion_actual())
                        .ofertaIsisPropuesto(s.getOfertaIsisPropuesto())
                        .accionIsisIdPropuesto((s.getAccionIsis() == null ? 0 : s.getAccionIsis().getId()))
                        .tipoCircuitoIdPropuesto((s.getTipocircuitopropuesto() == null ? 0 : s.getTipocircuitopropuesto().getId()))
                        .tipoServicioIdPropuesto((s.getTipoServicioPropuesto() == null ? 0 : s.getTipoServicioPropuesto().getId()))
                        .svaPropuesto(s.getSvaPropuesto())
                        .descripcionSvaPropuesto(s.getDescripcionSvaPropuesto())

                        .fechaLlegadaPropuesto(s.getFechaLlegadaPropuesto())
                        .componentesPropuesto(s.getComponentesPropuesto())
                        .vrfPropuesto(s.getVrfPropuesto())
                        .detalleAccionEnlacePropuesto(s.getDetalleAccionEnlacePropuesto())

                        .bwPropuesto(s.getBwPropuesto())
                        .caudalBroncePropuesto(s.getCaudalBroncePropuesto())
                        .caudalPlataPropuesto(s.getCaudalPlataPropuesto())
                        .caudalOroPropuesto(s.getCaudalOroPropuesto())
                        .caudalPlatinumPropuesto(s.getCaudalPlatinumPropuesto())
                        .caudalVozPropuesto(s.getCaudalVozPropuesto())
                        .caudalVideoPropuesto(s.getCaudalVideoPropuesto())
                        .CaudalLdnPropuesto(s.getCaudalLdnPropuesto())
                        .viaAccesoIdPropuesto((s.getViaAcceso() == null ? 0 : s.getViaAcceso().getId()))
                        .equipoTerminalPropuesto(s.getEquipoTerminalPropuesto())
                        .routerPropuesto(s.getRouterPropuesto())
                        .equipoStockPropuesto(s.getEquipoStockPropuesto())
                        .otrosEquiposPropuesto(s.getOtrosEquiposPropuesto())
                        .costoUltimaMilla(s.getCostoUltimaMilla())
                        .diasEjecucion(s.getDiasEjecucion())

                        .observacionesPropuesto(s.getObservacionesPropuesto())
                        .precioPropuesto(s.getPrecioPropuesto())
                        .codigoSisego(s.getCodigoSisego())
                        .zonaSisego(s.getZonaSisego())
                        .transmision(s.getTransmision())
                        .planta_externa(s.getPlanta_externa())
                        .residual_antig(s.getResidual_antig())
                        .residual_antig_costo(s.getResidual_antig_costo())
                        .build()
        ).collect(Collectors.toList());
        oDto.setData(ol);
        return oDto;
    }
}
