package cz.upol.cmtf.cato.utils;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;



public class TimestampUtils {

	private static final LocalTime EOD = new LocalTime(23, 59, 59, 999);
	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private TimestampUtils() {
	}

	/**
	 * Converts from timestamp to Local date
	 * 
	 * @param timestamp
	 * @return
	 */
	public static LocalDate timestampToLocalDate(Timestamp timestamp) {
		return timestamp == null ? null : LocalDate.fromDateFields(timestamp);
	}

	/**
	 * Converts from Local date to timestamp
	 * 
	 * @param localDate
	 * @return
	 */
	public static Timestamp localDateToTimestamp(LocalDate localDate) {
		return localDate == null ? null : new Timestamp(localDate.toDateTimeAtStartOfDay(DateTimeZone.UTC).getMillis());
	}

	/**
	 * Converts from Local date to timestamp end of day
	 * 
	 * @param localDate
	 * @return
	 */
	public static Timestamp localDateToTimestampEOD(LocalDate localDate) {
		return localDate == null ? null : new Timestamp(localDate.toDateTime(EOD, DateTimeZone.UTC).getMillis());
	}

	/**
	 * Converts from timestamp to Local date time
	 * 
	 * @param timestamp
	 * @return
	 */
	public static LocalDateTime timestampToLocalDateTime(Timestamp timestamp) {
		return timestamp == null ? null
				: new DateTime(timestamp.toInstant().toEpochMilli(), DateTimeZone.UTC).toLocalDateTime();
	}
	
	/**
	 * Converts from timestamp to Local date time with specific timezone
	 * 
	 * @param timestamp
	 * @param timezone
	 * @return
	 */
	public static LocalDateTime timestampToLocalDateTime(Timestamp timestamp, String timezone) {
		if (StringUtils.isBlank(timezone)) {
			timezone = "UTC";
		}
		return timestamp == null ? null
				: new DateTime(timestamp.toInstant().toEpochMilli(), DateTimeZone.forID(timezone)).toLocalDateTime();
	}
	
	/**
	 * Converts from Local date time from specific timezone to timestamp in UTC
	 * 
	 * @param localDateTime
	 * @param timezone
	 * @return
	 */
	public static Timestamp localDateTimeToTimestamp(LocalDateTime localDateTime, String timezone) {
		if (StringUtils.isBlank(timezone)) {
			timezone = "UTC";
		}

		return localDateTime == null ? null : new Timestamp(localDateTime.toDateTime(DateTimeZone.forID(timezone)).toDateTime(DateTimeZone.UTC).getMillis());
	}

	/**
	 * Converts from Local date time to timestamp
	 * 
	 * @param localDateTime
	 * @return
	 */
	public static Timestamp localDateTimeToTimestamp(LocalDateTime localDateTime) {
		return localDateTime == null ? null : new Timestamp(localDateTime.toDateTime(DateTimeZone.UTC).getMillis());
	}

	/**
	 * Converts String in format yyyy-MM-dd HH:mm:ss to Timestamp
	 * 
	 * @param dateTime
	 * @return
	 */
	public static Timestamp stringDateTimeToTimestamp(String dateTime) {
		return stringDateTimeToTimestamp(dateTime, DATE_TIME_FORMAT);
	}

	/**
	 * Converts String in format to Timestamp
	 * 
	 * @param dateTime
	 * @return
	 */
	public static Timestamp stringDateTimeToTimestamp(String dateTime, String format) {
		return isBlank(dateTime) ? null
				: localDateTimeToTimestamp(LocalDateTime.parse(dateTime, DateTimeFormat.forPattern(format)));
	}

	/**
	 * Return LocalDateTime now as timestamp
	 * 
	 * @return
	 */
	public static Timestamp now() {
		return localDateTimeToTimestamp(LocalDateTime.now(DateTimeZone.UTC));
	}

	/**
	 * Return LocalDate now as timestamp
	 * 
	 * @return
	 */
	public static Timestamp today() {
		return localDateToTimestamp(LocalDate.now(DateTimeZone.UTC));
	}

	/**
	 * Check if timestamp is between to timestamps (closed interval)
	 * 
	 * @param checkedDate
	 * @param from
	 * @param to
	 * @return
	 */
	public static boolean isBetween(Timestamp checkedDate, Timestamp from, Timestamp to) {
		if (checkedDate == null || from == null || to == null) {
			return false;
		}
		return checkedDate.compareTo(from) >= 0 && checkedDate.compareTo(to) <= 0;
	}

	/**
	 * Return timestamp plus added hours
	 * 
	 * @param date
	 * @param hours
	 * @return
	 */
	public static Timestamp plusHours(Timestamp date, int hours) {
		return new Timestamp(date.getTime() + (1000L * 60L * 60L * hours));
	}

	/**
	 * Return timestamp minus added hours
	 * 
	 * @param date
	 * @param hours
	 * @return
	 */
	public static Timestamp minusHours(Timestamp date, int hours) {
		return new Timestamp(date.getTime() - (1000L * 60L * 60L * hours));
	}

}