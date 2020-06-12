package com.incloud.tgestiona.b2b.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.incloud.tgestiona.b2b.model.oferta.Ofertas;
import com.incloud.tgestiona.b2b.model.oferta.OfertasDetalle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.stream.Stream;

@Repository
public interface OfertasDetalleRepository  extends JpaRepository<OfertasDetalle, Integer>, JpaSpecificationExecutor<OfertasDetalle>  {
    @Procedure("sp_guardar_servicio")
    int guardarServicio(
            Integer pofertaid,
            Boolean pactivo,
            Integer pid,
            String psede,
            String pdireccion,
            Integer piddistrito,
            String plat,
            String plon,
            String pcontacto,
            String ptelefono,
            Integer pidcircuito,
            String pcircuito,
            Integer pidservicio,
            Integer pidmedio,
            String pbwactual,
            String pldnactual,
            String pvozactual,
            String pvideoactual,
            String pplatiniumactual,
            String poroactual,
            String pplataactual,
            String pbronceactual,
            String pequipo,
            String prouter,
            Integer pdte_actual,
            String precursotransporteactual,
            String ptipoantenaactual,
            Integer psegmentosatelitalactual,
            String ppozotierraactual,
            String pupsactual,
            String pvrfactual,
            String potros,
            BigDecimal pfacturacion,
            Integer pidaccionisis,
            Integer pidtiposede,
            Integer pidmodo,
            Integer pidcircuito2,
            String pcircuito2,
            Integer pidservicio2,
            Integer pidmedio2,
            String psva,
            String psvadescripcion,
            Date pfechallegada,
            String pcomponentes,
            String pvrfpropuesto,
            String pdetalleaccionpropuesto,
            String pbwpropuesto,
            String pldnpropuesto,
            String pvozpropuesto,
            String pvideopropuesto,
            String pplatiniumpropuesto,
            String poropropuesto,
            String pplatapropuesto,
            String pbroncepropuesto,
            String pequipo2,
            String prouter2,
            String potros2,
            BigDecimal pprecio,
            String pobservaciones,
            String pofertaisis,
            String psisego,
            String pzona,
            BigDecimal pultima,
            Integer pdias,
            String pubigeo,
            Integer pcondicion_servicio,
            BigDecimal ptransmision,
            BigDecimal pplanta_externa,
            Integer presidual_antiguedad,
            BigDecimal presidual_antiguedad_costo
    );
}
