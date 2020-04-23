package com.incloud.tgestiona.util;

import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;

public class MessagesUtils {

	// For me check 
	public static String getErrorException(Exception e) {
		String retorno = null;
		if (StringUtils.isNotBlank(e.getMessage()))
			return e.getMessage();
		if (StringUtils.isNotBlank(e.getLocalizedMessage()))
			return e.getLocalizedMessage();
		retorno = e.toString();
		return retorno;
	}

	public static String getErrorExceptionDebug(Exception e) {
		String error = getErrorException(e);
		if (StringUtils.isNotBlank(error)) {
			int buscar = StringUtils.indexOf(error, "Exception:");
			if (buscar > 0) {
				error = StringUtils.right(error, buscar + 1);
			}
		}
		return error;
	}

	protected HttpHeaders returnErrorHeaders(Exception e) {
		String msjError = getErrorExceptionDebug(e);
		HttpHeaders headers = new HttpHeaders();
		headers.add("errors", msjError);
		return headers;
	}

	
	
	public static int getRandomNumberInts(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }

    public static String getMensageErrorException(Exception e) {
        String retorno = null;
        if (StringUtils.isNotBlank(e.getMessage()))
            return e.getMessage();
        if (StringUtils.isNotBlank(e.getLocalizedMessage()))
            return e.getLocalizedMessage();
        retorno = e.toString();
        return retorno;
    }

    public static String getMensageErrorExceptionDebug(Exception e) {
        String error = getMensageErrorException(e);
        if (StringUtils.isNotBlank(error)) {
            int buscar = StringUtils.indexOf(error, "Exception:");
            if (buscar > 0) {
                error = StringUtils.right(error, buscar + 1);
            }
        }
        return error;
    }

    public static String obtenerSiguienteMesEjercicio(Integer ejercicio, String mes ) {
        Integer nMes = new Integer(mes);
        Integer nAnno = ejercicio;
        if (nMes.intValue() < 12) {
            nMes += 1;
        }
        else {
            nMes = 1;
            nAnno ++;
        }
        String mesProceso = StringUtils.leftPad(nMes.toString().trim(), 2, '0');
        String ejercicioProceso = nAnno.toString().trim();
        return mesProceso + "/" + ejercicioProceso;
    }
}
