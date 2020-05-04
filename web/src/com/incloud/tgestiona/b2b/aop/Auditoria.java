package com.incloud.tgestiona.b2b.aop;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incloud.tgestiona.b2b.model.AppProcesoLog;
import com.incloud.tgestiona.b2b.servicesImpl.AppProcesoLogServiceImpl;
import com.incloud.tgestiona.util.DateUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class Auditoria {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String EXITO = "1";
	private final String ERROR = "0";
	private final String mensajeOK = "OK";
	private final int MAXIMO_CARACTERES_SALIDA = 3950;

    @Autowired
    private MessageSource messageSource;
    
	@Autowired
	private AppProcesoLogServiceImpl appProcesoLogService;

	protected Object logExecutionTime(ProceedingJoinPoint joinPoint, String nameLogAnotacion) throws Throwable {

		Object proceed;

		long start = System.currentTimeMillis();
		AppProcesoLog logSystem = new AppProcesoLog();

		logSystem.setFechaInicioEjecucion(DateUtils.obtenerFechaHoraActual());
		logSystem.setDescripcionEstadoEjecucion(this.mensajeOK);
		logSystem.setEstadoEjecucion(EXITO);

		/* get name of Class and Method */
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		logSystem.setClaseProgramacion(signature.getDeclaringType().getSimpleName());

		String claseHija = joinPoint.getTarget().getClass().getSimpleName();
		if (Optional.ofNullable(claseHija).isPresent()) {
			logSystem.setClaseProgramacion(claseHija);
		}

		logSystem.setMetodoProgramacion(signature.getName());

		/*
		 * Begin log4J
		 */
		logger.error("Log logVentaExecutionTime - joinPoint:  " + joinPoint.toString());
		logger.error(
				"Log logVentaExecutionTime - setClaseProgramacion:  " + signature.getDeclaringType().getSimpleName());
		logger.error("Log logVentaExecutionTime - signature:  " + signature.toString());
		logger.error("Log logVentaExecutionTime - method:  " + method.toString());
		logger.error("Log logVentaExecutionTime - claseHija:  " + claseHija.toString());

		/* Get parameter input */
		// Object[] argsO = joinPoint.getArgs();
		List<Object> listaParametrosTmp = null;
		List<Object> listaParametros = new ArrayList<>();

		try {

			// Object target = joinPoint.getTarget();
			listaParametrosTmp = Arrays.asList(joinPoint.getArgs());

			for (Object obj : listaParametrosTmp) {
				if (!(obj instanceof HttpServletRequest || obj instanceof BindingResult
						|| obj instanceof UriComponentsBuilder)) {
					listaParametros.add(obj);
				}

			}

			if (listaParametros != null && listaParametros.size() > 0) {
				ObjectMapper mapperEntrada = new ObjectMapper();
				mapperEntrada.setSerializationInclusion(Include.NON_NULL);
				String parametros = mapperEntrada.writerWithDefaultPrettyPrinter().writeValueAsString(listaParametros);
				if (parametros.length() >= MAXIMO_CARACTERES_SALIDA) {
					parametros = parametros.substring(0, MAXIMO_CARACTERES_SALIDA);
				}
				logSystem.setParametroEntrada(parametros);

			}

		} catch (Exception e) {
			/// errorMensaje = Utils.obtieneMensajeErrorException(e);
			logger.error("Log logVentaExecutionTime - exception 01 - " + e.getMessage());
			logger.error(
					"Log logVentaExecutionTime - exception 01 - listaParametros - listaParametros: " + listaParametros);
			logSystem.setParametroEntrada(null);
		}

		logSystem.setModulo("B2B");// Check HOliveros

		/* Method ejecute */
		try {
			proceed = joinPoint.proceed();

			try {

				if (proceed != null) {
					
					ObjectMapper mapperOut = new ObjectMapper();
					mapperOut.setSerializationInclusion(Include.NON_NULL);
					String outResult = mapperOut.writerWithDefaultPrettyPrinter().writeValueAsString(proceed);

					if (outResult.length() > MAXIMO_CARACTERES_SALIDA) {
						outResult = outResult.substring(0, MAXIMO_CARACTERES_SALIDA);
					}

					logSystem.setResultadoSalida(outResult);

				}

			} catch (Exception e) {

				// errorMensaje = Utils.obtieneMensajeErrorException(e);

				logger.error("Log logVentaExecutionTime - exception 02 - " + e.getMessage());
				logSystem.setResultadoSalida(null);

			}

		} catch (ServiceException ex) {

			logger.error("Log logVentaExecutionTime - service exception 03");
			
			// if(ex.getArgs() == null){
			// errorMensaje = messageSource.getMessage(ex.getKeyMessage(), new
			// Object[]{},null);
			// }else{
			// errorMensaje = messageSource.getMessage(ex.getKeyMessage(),
			// ex.getArgs(),null);
			// }

			// errorMensaje = Utils.obtieneMensajeErrorException(ex);
			// if (errorMensaje.length() > MAXIMO_CARACTERES_SALIDA) {
			// errorMensaje = errorMensaje.substring(0, MAXIMO_CARACTERES_SALIDA);
			// }
			/// logSistema.setDescripcionEstadoEjecucion(errorMensaje);
			logSystem.setDescripcionEstadoEjecucion(ex.getMessage());
			logSystem.setEstadoEjecucion(ERROR);
			throw ex;

		} catch (Exception e) {

			logger.error("Log logVentaExecutionTime - exception 04");
			// errorMensaje = Utils.obtieneMensajeErrorException(e);
			// if (errorMensaje.length() > MAXIMO_CARACTERES_SALIDA) {
			// errorMensaje = errorMensaje.substring(0, MAXIMO_CARACTERES_SALIDA);
			// }
			logSystem.setDescripcionEstadoEjecucion(e.getMessage());
			logSystem.setEstadoEjecucion(ERROR);
			throw e;

		} finally {

			/* Add data to table DB - LOG */
			logSystem.setFechaFinEjecucion(DateUtils.obtenerFechaHoraActual());
			long executionTime = System.currentTimeMillis() - start;
			logSystem.setDuracionMs((int) executionTime);
			logger.error("Log logVentaExecutionTime - logSistema:  " + logSystem.toString());

			if (!logSystem.getClaseProgramacion().equals("AppProcesoLogServiceImpl"))
				this.appProcesoLogService.save(logSystem);

		}

		logger.error("Log logVentaExecutionTime - FIN:  " + logSystem.toString());
		return proceed;

	}

}