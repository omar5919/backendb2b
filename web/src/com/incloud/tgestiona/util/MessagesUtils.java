package com.incloud.tgestiona.util;

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

}
