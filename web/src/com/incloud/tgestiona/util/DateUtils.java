package com.incloud.tgestiona.util;

import java.time.*;
import java.util.Date;

public class DateUtils {

	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String DEFAULT_ZONE_ID = "America/Lima";
	public static final String DATE_TIME_FORMAT_RESOURCES = "yyyy-MM-dd HH:mm";

	public DateUtils() {

		System.out.println("Begin Utils");
	}

	public static ZonedDateTime getDefaultCurrentZonedDateTime() {
		return getCurrentZonedDateTime(ZoneId.of(DEFAULT_ZONE_ID));
	}

	public static ZonedDateTime getCurrentZonedDateTime(ZoneId zoneId) {
		Instant now = Instant.now();
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, zoneId);
		return zonedDateTime;
	}

//	public static ZonedDateTime getDefaultZonedDateTimeFromDate(Date date) {
//		return getZonedDateTimeFromDate(date, ZoneId.of(DEFAULT_ZONE_ID));
//	}

	public static Date obtenerFechaHoraActual() {
		ZoneId zona = ZoneId.systemDefault();
		Date fechaActual = Date.from(LocalDateTime.now().atZone(zona).toInstant());
		return fechaActual;
	}

	public static Date obtenerFechaHoraActualMinusMin(long minutes) {
		ZoneId zona = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.now();
		localDateTime = localDateTime.minusMinutes(minutes);
		Date fechaActual = Date.from(localDateTime.atZone(zona).toInstant());
		return fechaActual;
	}

	public static Date obtenerFechaHoraActualPlusMin(long minutes) {
		ZoneId zona = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.now();
		localDateTime = localDateTime.plusMinutes(minutes);
		Date fechaActual = Date.from(localDateTime.atZone(zona).toInstant());
		return fechaActual;
	}

	public static Date obtenerFechaHoraActualPlusHora(long horas) {
		ZoneId zona = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.now();
		localDateTime = localDateTime.plusHours(horas);
		Date fechaActual = Date.from(localDateTime.atZone(zona).toInstant());
		return fechaActual;
	}

}
