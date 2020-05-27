package com.incloud.tgestiona.b2b.serices;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface IsisService {
    List<Object[]> ofertaPorGrupoSede(Integer p_oferta_id);
    List<Object[]> datosGenerales(Integer oferta_id);
    List<Object[]> target(Integer oferta_id,String nombre_sede);
    List<Object[]> direccion(Integer oferta_id,String nombre_sede);
    List<Object[]> gruposParametros(Integer oferta_id,
                                    String nombre_sede,
                                    String oferta_isis,
                                    String version_isis);
    List<Object[]> equipoNoEstandar(Integer oferta_id,String nombre_sede);
    List<Object[]> equipoEstandar(Integer oferta_id,String nombre_sede);
    List<Object[]> implantacionNoEstandar(Integer oferta_id,String nombre_sede);
    List<Object[]> tarifario(Integer oferta_id,String nombre_sede);
}
