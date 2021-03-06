package com.incloud.tgestiona.b2b.services.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incloud.tgestiona.b2b.repository.IsisRepository;
import com.incloud.tgestiona.b2b.service.dto.isis.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/isis")
public class IsisRest {

	private static final String urlIsis = "https://api.us.apiconnect.ibmcloud.com/telefonica-del-peru-development/ter/integracionmaestraservice/v1/";
    
    private static final String urlCabecera = 				"registerHeader";
    private static final String urlGrupos = 				"registerGroups";
    private static final String urlEquipoEstandar = 		"registerStandardEquipment";
    private static final String urlEquipoNoEstandar = 		"registerNonStandardEquipment";
    private static final String urlImplmentacionNoEstandar = 	"registerNonStandardImplementation";
    private static final String urlTarget = 				"registerTarget";
    private static final String urlPresupuesto = 			"registerBudget";
    private static final String urlDireccion = 				"registerAddress";

    @Autowired
    private IsisRepository iRepo;
    
    private static  Logger log = LoggerFactory.getLogger(ResponseDto.class);
    
    
    @PostMapping("/enviartrama")
    public ResponseDto enviar(@RequestParam Integer oferta_id) throws JsonProcessingException {
    	 ResponseDto result;
        try {
           
            return  ofertaPorSede(oferta_id);
        } catch (final HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                ObjectMapper mapper = new ObjectMapper();
                  result = mapper.readValue(e.getResponseBodyAsString(), ResponseDto.class);
            }else {
            	
            	 ObjectMapper mapper = new ObjectMapper();
                   result = mapper.readValue(e.getResponseBodyAsString(), ResponseDto.class);
            }
            log.info(e.toString());
            return result;
        }
    }

 
    private static <T> ResponseEntity<ResponseDto> enviarTrama(T req, String url) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("X-IBM-Client-Id", "57505cf4-96b7-4f2b-88ee-d25a4a02c3fb");
        HttpEntity<T> entity = new HttpEntity<T>(req, headers);
        ResponseEntity<ResponseDto> res = restTemplate.postForEntity(urlIsis+url, entity, ResponseDto.class);
        
        log.info(res.toString());
        return res;
        
    }
    
    public  ResponseDto ofertaPorSede(Integer ofertaId) {
    	ResponseEntity<ResponseDto> objRpt = null ;
        String ofertaIsis = "";
        String versionIsis = "";
   
        String nombreSede = "";
        Integer sedeId = 0;
       
        List<Object[]> _ofertaPorGrupoSede = iRepo.ofertaPorGrupoSede(ofertaId);
        for (Object[] obj : _ofertaPorGrupoSede) {
        	sedeId = (Integer) obj[2];
            nombreSede = (String) obj[3];
            ofertaIsis = (String) obj[4];
  	        
	        if(ofertaIsis.equals("")) {//--- valida si no hay una oferta isis  	        
	        	objRpt = enviarCabeceraDatosGenerales(ofertaId);
	        	ofertaIsis = objRpt.getBody().getProyecto().toString();
	        	versionIsis = objRpt.getBody().getVersion().toString();
	        } 
	        log.info("<== Codigo Isis Generado ==> " +  ofertaIsis);
	        objRpt = enviarGrupoParametros(ofertaId, nombreSede, ofertaIsis, versionIsis);
	        
	        objRpt = enviarEquipoEstandar(ofertaId, nombreSede); 
	        objRpt = enviarEquipoNoEstandar(ofertaId, nombreSede);  
	        objRpt = enviarImplantacionNoEstandar(ofertaId, nombreSede);  
	        objRpt = enviarTarget(ofertaId, nombreSede);  
	        objRpt = enviarTarifario(ofertaId, nombreSede);  
	        objRpt = enviarDireccion(ofertaId, nombreSede);  
	        
	        objRpt.getBody().setProyecto(Integer.parseInt(ofertaIsis.toString().trim()== "" ? "0":ofertaIsis.toString()));
	        objRpt.getBody().setVersion(Integer.parseInt(versionIsis.toString().trim() == "" ? "1" :versionIsis.toString()));
          }
		return objRpt.getBody();
        
    }
    
    private ResponseEntity<ResponseDto> enviarCabeceraDatosGenerales(Integer ofertaId) {
    	ResponseEntity<ResponseDto> RptObj = null;
    	 List<Object[]> _datosGenerales = iRepo.datosGenerales(ofertaId);
	        for (Object[] obj : _datosGenerales) {
	        	DatosGeneralesIntIsisDto _dGenerales = new DatosGeneralesIntIsisDto();
		        	_dGenerales.setOfe_sdio((String)obj[0]);
		        	_dGenerales.setCod_cliente((String)obj[3]);
		        	_dGenerales.setCod_fact((String)obj[4]);
		        	_dGenerales.setDescripcion((String)obj[5]);
		        	_dGenerales.setCod_oportunidad((String)obj[6]);
		        	_dGenerales.setTipo_oportunidad((String)obj[7]);
		        	_dGenerales.setContacto((String)obj[8]);
		        	_dGenerales.setTelefono((String)obj[9]);
		        	_dGenerales.setMoneda((String)obj[10]);
		        	_dGenerales.setTipo((String)obj[11]);
		        	_dGenerales.setUsuario((String)obj[12]);
		        	RptObj	=  enviarTrama(_dGenerales,urlCabecera);///-->> cabecera
	        }      
    	return RptObj;
    }
    
    private ResponseEntity<ResponseDto> enviarGrupoParametros(Integer ofertaId,String nombreSede,String oferta_isis,String versionIsis){
    	ResponseEntity<ResponseDto> RptObj = null; 
    	List<Object[]> _grupoParametros = iRepo.gruposParametros(ofertaId, nombreSede, oferta_isis, versionIsis);
	        for (Object[] obj : _grupoParametros) {
	        	GrupoParametrosIntIsisDto _gParamGrupo = new GrupoParametrosIntIsisDto();
	        	_gParamGrupo.setProyecto((String)obj[0]);
	        	_gParamGrupo.setVersion((String)obj[1]);
	        	_gParamGrupo.setCantidad((Integer)obj[2]);
	        	_gParamGrupo.setSec_grupo((Integer)obj[3]);
	        	_gParamGrupo.setGrupo((String)obj[4]);
	        	_gParamGrupo.setSec_direccion((Integer)obj[5]);
	        	_gParamGrupo.setDireccion((String)obj[6]);
	        	_gParamGrupo.setSec_prod((Integer)obj[7]);
	        	_gParamGrupo.setCod_prod((String)obj[8]);
	        	_gParamGrupo.setTipo_servicio((String)obj[9]);
	        	_gParamGrupo.setServicio((String)obj[10]);
	        	_gParamGrupo.setTipo_de_servicio((String)obj[11]);
	        	_gParamGrupo.setAccion_isis((String)obj[12]);
	        	_gParamGrupo.setBw((String)obj[13]);
	        	_gParamGrupo.setMedio_acceso((String)obj[14]);
	        	_gParamGrupo.setCaudal_ldn((String)obj[15]);
	        	_gParamGrupo.setCaudal_voz((String)obj[16]);
	        	_gParamGrupo.setCaudal_video((String)obj[17]);
	        	_gParamGrupo.setCaudal_platinum((String)obj[18]);
	        	_gParamGrupo.setCaudal_oro((String)obj[19]);
	        	_gParamGrupo.setCaudal_plata((String)obj[20]);
	        	_gParamGrupo.setCaudal_bronce((String)obj[21]);
	        	_gParamGrupo.setTipo_de_cd((String)obj[22]);
	        	RptObj	= enviarTrama(_gParamGrupo,urlGrupos);///-->> grupo - parametros
	        }
	        return RptObj;
    }

    private ResponseEntity<ResponseDto> enviarEquipoEstandar(Integer ofertaId,String nombreSede) {
    	ResponseEntity<ResponseDto> RptObj = null; 
        List<Object[]> _equipoStandar = iRepo.equipoEstandar(ofertaId, nombreSede);
        for (Object[] obj : _equipoStandar) {
        	EquipoStandarIntIsisDto _eEstandar = new EquipoStandarIntIsisDto();
        	_eEstandar.setProyecto((String)obj[0]);
        	_eEstandar.setVersion((String)obj[1]);
        	_eEstandar.setSec_grupo((Integer)obj[2]);
        	_eEstandar.setSec_direccion((Integer)obj[3]);
        	_eEstandar.setSec_prod((Integer)obj[4]);
        	_eEstandar.setCod_prod((String)obj[5]);
        	_eEstandar.setTipo_equipo((String)obj[6]);
        	_eEstandar.setServicio((String)obj[7]);
        	_eEstandar.setAnos_de_contrato((Integer)obj[8]);
        	_eEstandar.setCantidad((Integer)obj[9]);
        	
        	RptObj = enviarTrama(_eEstandar,urlEquipoEstandar);///-->> equipo estandar
        }

    	return RptObj;
    }
    
    private ResponseEntity<ResponseDto> enviarEquipoNoEstandar(Integer ofertaId,String nombreSede) {
    	ResponseEntity<ResponseDto> RptObj = null; 
    	List<Object[]> _equipoNoStandar = iRepo.equipoNoEstandar(ofertaId, nombreSede);
        for (Object[] obj : _equipoNoStandar) {
        	  EquipoNoStandarIntIsisDto _eNEstandar = new EquipoNoStandarIntIsisDto();
              _eNEstandar.setProyecto((String)obj[0]);
              _eNEstandar.setVersion((String)obj[1]);
              _eNEstandar.setSec_grupo((Integer)obj[2]);
              _eNEstandar.setSec_direccion((Integer)obj[3]);
              _eNEstandar.setSec_prod((Integer)obj[4]);
              _eNEstandar.setCod_prod((String)obj[5]);
              _eNEstandar.setDestino((String)obj[6]);
              _eNEstandar.setTipo_de_equipo((String)obj[7]);
              _eNEstandar.setDescripcion((String)obj[8]);
              _eNEstandar.setAnos_de_contrato((Integer)obj[9]);

              RptObj =  enviarTrama(_eNEstandar,urlEquipoNoEstandar);///-->> equipo  non estandar

        }
    	return RptObj;
    }

    private ResponseEntity<ResponseDto>   enviarImplantacionNoEstandar(Integer ofertaId,String nombreSede) {
    	ResponseEntity<ResponseDto> RptObj = null; 
    	 List<Object[]> _ImplantacionNoStandar = iRepo.implantacionNoEstandar(ofertaId, nombreSede);
	        for (Object[] obj : _ImplantacionNoStandar) {
	        	ImplantacionNoStandarIntIsisDto _iNEstandar = new ImplantacionNoStandarIntIsisDto();
	        	_iNEstandar.setProyecto((String)obj[0]);
	        	_iNEstandar.setVersion((String)obj[1]);
	        	_iNEstandar.setSec_grupo((Integer)obj[2]);
	        	_iNEstandar.setSec_direccion((Integer)obj[3]);
	        	_iNEstandar.setSec_prod((Integer)obj[4]);
	        	_iNEstandar.setCod_prod((String)obj[5]);
	        	_iNEstandar.setTipo_estudio((String)obj[6]);
	        	_iNEstandar.setCodigo_sisego((String)obj[7]);
	        	_iNEstandar.setDescripcion((String)obj[8]);
	        	_iNEstandar.setCantidad((Integer)obj[9]);
	        	_iNEstandar.setMoneda((Integer)obj[10]);
	        	_iNEstandar.setCodigo_tarifa((String)obj[11]);
	        	_iNEstandar.setSecuencia_tarifa(12);
	
	        	RptObj = enviarTrama(_iNEstandar,urlImplmentacionNoEstandar);///-->> implamtacion no estandar
	            
	        }
	     	return RptObj;
    }
  
    private ResponseEntity<ResponseDto>   enviarTarget(Integer ofertaId,String nombreSede) {
    	ResponseEntity<ResponseDto> RptObj = null; 
    	 List<Object[]> _target = iRepo.target(ofertaId, nombreSede);
	        for (Object[] obj : _target) {
	        	TargetIntIsisDto _targetd = new TargetIntIsisDto();
	        	_targetd.setProyecto((String)obj[0]);
	        	_targetd.setVersion((String)obj[1]);
	        	_targetd.setPago_unico((BigDecimal)obj[2]);
	        	_targetd.setPago_recurrente((BigDecimal)obj[3]);
	        	
	        	RptObj =	enviarTrama(_targetd,urlTarget);///-->> target
	        	
	        }

	     	return RptObj;
    }

    private ResponseEntity<ResponseDto> enviarTarifario(Integer ofertaId,String nombreSede) {
      	 
    	ResponseEntity<ResponseDto> RptObj = null; 
        List<Object[]> _tarifario = iRepo.tarifario(ofertaId, nombreSede);
        for (Object[] obj : _tarifario) {
        	TarifarioIntIsisDto _tarifariod = new TarifarioIntIsisDto();
        	_tarifariod.setProyecto((String)obj[0]);
        	_tarifariod.setVersion((String)obj[1]);
        	_tarifariod.setSec_grupo((Integer)obj[2]);
        	_tarifariod.setSec_direccion((Integer)obj[3]);
        	_tarifariod.setSec_prod((Integer)obj[4]);
        	_tarifariod.setCod_prod((String)obj[5]);
        	_tarifariod.setCod_conc((String)obj[6]);
        	_tarifariod.setSec_concep((Integer)obj[7]);
        	_tarifariod.setTipo_pago((String)obj[8]);
        	_tarifariod.setCodigo_tarifa((String)obj[9]);
        	_tarifariod.setSeq_tarifa((Integer)obj[10]);
        	_tarifariod.setInd_dscto((String)obj[11]);
        	_tarifariod.setTipo_dscto((String)obj[12]);
        	_tarifariod.setMon_dscto((BigDecimal)obj[13]);
        	_tarifariod.setDestino((String)obj[14]);
        	_tarifariod.setOrigen_concepto((String)obj[15]);

        	RptObj=enviarTrama(_tarifariod,urlPresupuesto);///-->> tarifario
        	
        }
     	return RptObj;
   	
   }

    private ResponseEntity<ResponseDto> enviarDireccion(Integer ofertaId,String nombreSede) {
    	ResponseEntity<ResponseDto> RptObj = null;  
       
        List<Object[]> _direccion = iRepo.direccion(ofertaId, nombreSede);
        for (Object[] obj : _direccion) {
        	DireccionIntIsisDto _Direcciond = new DireccionIntIsisDto();
        	_Direcciond.setProyecto((String)obj[0]);
        	_Direcciond.setVersion((String)obj[1]);
        	_Direcciond.setSec_grupo((Integer)obj[2]);
        	_Direcciond.setSec_direccion((Integer)obj[3]);
        	_Direcciond.setCod_departamento((String)obj[4]);
        	_Direcciond.setCod_provincia((String)obj[5]);
        	_Direcciond.setCod_distrito((String)obj[6]);
        	_Direcciond.setCod_ciudad((String)obj[7]);
        	_Direcciond.setCod_urbanizacion((String)obj[8]);
        	_Direcciond.setCod_via((String)obj[9]);
        	_Direcciond.setCodigo((String)obj[10]);
        	_Direcciond.setDireccion((String)obj[11]);
        	_Direcciond.setNumero((String)obj[12]);
        	_Direcciond.setManzana((String)obj[13]);
        	_Direcciond.setLote((String)obj[14]);
        	_Direcciond.setPiso((String)obj[15]);
        	_Direcciond.setInterior((String)obj[16]);

        	RptObj =	enviarTrama(_Direcciond,urlDireccion);///-->> direccion
        }
        
   	return RptObj;
   }
}


