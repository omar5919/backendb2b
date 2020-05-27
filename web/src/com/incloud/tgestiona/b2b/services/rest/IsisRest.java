package com.incloud.tgestiona.b2b.services.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incloud.tgestiona.b2b.repository.IsisRepository;
import com.incloud.tgestiona.b2b.service.dto.isis.*;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/isis")
public class IsisRest {

    private static final String urlCabecera = "https://api.us.apiconnect.ibmcloud.com/telefonica-del-peru-development/ter/integracionmaestraservice/v1/registerHeader";
    private static final String urlGrupos = "https://api.us.apiconnect.ibmcloud.com/telefonica-del-peru-development/ter/integracionmaestraservice/v1/registerGroups";
    private static final String urlEquipoEstandar = "https://api.us.apiconnect.ibmcloud.com/telefonica-del-peru-development/ter/integracionmaestraservice/v1/registerStandardEquipment";
    private static final String urlEquipoNoEstandar = "https://api.us.apiconnect.ibmcloud.com/telefonica-del-peru-development/ter/integracionmaestraservice/v1/registerNonStandardEquipment";
    private static final String urlEquipoNoEstandarImpl = "https://api.us.apiconnect.ibmcloud.com/telefonica-del-peru-development/ter/integracionmaestraservice/v1/registerNonStandardImplementation";
    private static final String urlTarget = "https://api.us.apiconnect.ibmcloud.com/telefonica-del-peru-development/ter/integracionmaestraservice/v1/registerTarget";
    private static final String urlPresupuesto = "https://api.us.apiconnect.ibmcloud.com/telefonica-del-peru-development/ter/integracionmaestraservice/v1/registerBudget";
    private static final String urlDireccion = "https://api.us.apiconnect.ibmcloud.com/telefonica-del-peru-development/ter/integracionmaestraservice/v1/registerAddress";

    @Autowired
    private IsisRepository iRepo;

    @PostMapping("/enviartrama")
    public Integer Enviar(@RequestParam Integer oferta_id) throws JsonProcessingException {
        try {
            OfertaPorSede(oferta_id);
            return 1;
        } catch (final HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                ObjectMapper mapper = new ObjectMapper();
                ResponseDto result = mapper.readValue(e.getResponseBodyAsString(), ResponseDto.class);
            }
            return 0;
        }
    }

    private static <T> void Guardar(T req, String url) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("X-IBM-Client-Id", "57505cf4-96b7-4f2b-88ee-d25a4a02c3fb");
        HttpEntity<T> entity = new HttpEntity<T>(req, headers);
        ResponseEntity<String> res = restTemplate.postForEntity(url, entity, String.class);
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

        String nombre_sede = null;
        Integer sede_id = 0;
        List<Object[]> _ofertaPorGrupoSede = iRepo.ofertaPorGrupoSede(oferta_id);
        for (Object[] obj : _ofertaPorGrupoSede) {
            sede_id = (Integer) obj[2];
            nombre_sede = (String) obj[3];
        }

        RequestDto req = new RequestDto();
        req.setOfe_sdio("0001846");
        req.setCod_cliente("000002");
        req.setCod_fact("VA00080");
        req.setDescripcion("OFERTA SDIO TEST70");
        req.setCod_oportunidad("12455670");
        req.setTipo_oportunidad("PROY00080");
        req.setContacto("JUAN PEREZ");
        req.setTelefono("99012068");
        req.setMoneda(2);
        req.setTipo("01");
        req.setUsuario("RAMOSA");

        Guardar(req,urlCabecera);

        List<Object[]> _datosGenerales = iRepo.datosGenerales(oferta_id);
        for (Object[] obj : _datosGenerales) {
            //datosGenerales.add(new DatosGeneralesIntIsisDto( ) );
        }

        List<Object[]> _grupoParametros = iRepo.gruposParametros(oferta_id, nombre_sede, oferta_isis, version_isis);
        for (Object[] obj : _grupoParametros) {
            //grupoParametros.add(new GrupoParametrosIntIsisDto( ) );
        }
        List<Object[]> _equipoStandar = iRepo.equipoEstandar(oferta_id, nombre_sede);
        for (Object[] obj : _equipoStandar) {
            //equipoStandar.add(new EquipoStandarIntIsisDto( ) );
        }

        List<Object[]> _equipoNoStandar = iRepo.equipoNoEstandar(oferta_id, nombre_sede);
        for (Object[] obj : _equipoNoStandar) {
            //equipoNoStandar.add(new EquipoNoStandarIntIsisDto( ) );
        }

        EquipoNoStandarIntIsisDto req_1 = new EquipoNoStandarIntIsisDto();
        req_1.setNumero_proyecto_sdio("120875");
        req_1.setVersion_oferta("1");
        req_1.setSec_grupo(1);
        req_1.setSec_direccion(0);
        req_1.setSec_producto(2);
        //req_1.setCodigo_producto("1954");
        req_1.setDestino("");
        req_1.setTipo_equipo("02");
        //req_1.setdescripcion("");
        req_1.setAnio_contrato(1);
        Guardar(req_1,urlEquipoNoEstandar);

        List<Object[]> _ImplantacionNoStandar = iRepo.implantacionNoEstandar(oferta_id, nombre_sede);
        for (Object[] obj : _ImplantacionNoStandar) {
            //ImplantacionNoStandar.add(new ImplantacionNoStandarIntIsisDto( ) );
        }
        List<Object[]> _target = iRepo.target(oferta_id, nombre_sede);
        for (Object[] obj : _target) {
            //target.add(new TargetIntIsisDto( ) );
        }
        List<Object[]> _tarifario = iRepo.tarifario(oferta_id, nombre_sede);
        for (Object[] obj : _tarifario) {
            //tarifario.add(new TarifarioIntIsisDto( ) );
        }
        List<Object[]> _direccion = iRepo.direccion(oferta_id, nombre_sede);
        for (Object[] obj : _direccion) {
            //direccion.add(new DireccionIntIsisDto( ) );
        }
    }
}
