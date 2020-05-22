package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.repository.isis.IntegracionIsisRepository;
import com.incloud.tgestiona.b2b.service.dto.isis.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/isis")
public class IsisRest {

    @Autowired(required = false)
    public IntegracionIsisRepository RepoIntIsis;

    @PostMapping("/enviartrama")
    public void Enviar(@RequestParam Integer oferta_id) {
        OfertaPorSede(oferta_id);
    }

    private static void Guardar() {
        /*
        headers:{'X-IBM-Client-Id':'b865396f-032d-41a7-8836-fa941e0c0456'}
        Content-Type en json
        * */
        final String uri = "https://api.us.apiconnect.ibmcloud.com/telefonica-del-peru-development/ter/integracionmaestraservice/v1/registerHeader";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
    }

    public void OfertaPorSede(Integer oferta_id) {

        String oferta_isis = null;
        String version_isis = null;

        List<DatosGeneralesIntIsisDto> ofertaPorGrupoSede = new ArrayList<>();
        List<DatosGeneralesIntIsisDto> datosGenerales = new ArrayList<>();
        List<GrupoParametrosIntIsisDto> grupoParametros = new ArrayList<>();
        List<EquipoStandarIntIsisDto> equipoStandar = new ArrayList<>();
        List<EquipoNoStandarIntIsisDto> equipoNoStandar = new ArrayList<>();
        List<ImplantacionNoStandarIntIsisDto> ImplantacionNoStandar = new ArrayList<>();
        List<TargetIntIsisDto> target = new ArrayList<>();
        List<TarifarioIntIsisDto[]> tarifario = new ArrayList<>();
        List<DireccionIntIsisDto> direccion = new ArrayList<>();

        /**trae la informacion x cada grupo de sede**/
        String nombre_sede = null;
        Integer sede_id = 0;
        List<Object[]> _ofertaPorGrupoSede = RepoIntIsis.ofertaPorGrupoSede(oferta_id);
        for (Object[] obj : _ofertaPorGrupoSede) {
            sede_id = (Integer) obj[2];
            nombre_sede = (String) obj[3];
        }

        List<Object[]> _datosGenerales = RepoIntIsis.datosGenerales(oferta_id);
        for (Object[] obj : _datosGenerales) {
            //datosGenerales.add(new DatosGeneralesIntIsisDto( ) );
        }

        List<Object[]> _grupoParametros = RepoIntIsis.gruposParametros(oferta_id, nombre_sede, oferta_isis, version_isis);
        for (Object[] obj : _grupoParametros) {
            //grupoParametros.add(new GrupoParametrosIntIsisDto( ) );
        }
        List<Object[]> _equipoStandar = RepoIntIsis.equipoEstandar(oferta_id, nombre_sede);
        for (Object[] obj : _equipoStandar) {
            //equipoStandar.add(new EquipoStandarIntIsisDto( ) );
        }

        List<Object[]> _equipoNoStandar = RepoIntIsis.equipoNoEstandar(oferta_id, nombre_sede);
        for (Object[] obj : _equipoNoStandar) {
            //equipoNoStandar.add(new EquipoNoStandarIntIsisDto( ) );
        }
        List<Object[]> _ImplantacionNoStandar = RepoIntIsis.implantacionNoEstandar(oferta_id, nombre_sede);
        for (Object[] obj : _ImplantacionNoStandar) {
            //ImplantacionNoStandar.add(new ImplantacionNoStandarIntIsisDto( ) );
        }
        List<Object[]> _target = RepoIntIsis.target(oferta_id, nombre_sede);
        for (Object[] obj : _target) {
            //target.add(new TargetIntIsisDto( ) );
        }
        List<Object[]> _tarifario = RepoIntIsis.tarifario(oferta_id, nombre_sede);
        for (Object[] obj : _tarifario) {
            //tarifario.add(new TarifarioIntIsisDto( ) );
        }
        List<Object[]> _direccion = RepoIntIsis.direccion(oferta_id, nombre_sede);
        for (Object[] obj : _direccion) {
            //direccion.add(new DireccionIntIsisDto( ) );
        }
        //return null;
    }
}
