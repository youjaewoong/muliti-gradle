package cdp.common.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtil {
	public static String toDateDisplay(LocalDateTime value) {
		return toDateDisplay(value, false);
	}

	public static String toDateDisplay(LocalDateTime value, boolean includeHourMinute) {
		String result;
		long seconds = Duration.between(value, LocalDateTime.now()).getSeconds();

		if (seconds >= 0 && seconds < 120) { // 0 ~ 2분 미만
			result = "1분전";
		} else if (seconds >= 120 && seconds < 3600) { // 2분 이상 ~ 60분 미만
			result = String.format("%d분전", seconds / 60);
		} else if (seconds >= 3600 && seconds < 86400) { // 60분 이상 ~ 24시간 미만
			result = String.format("%d시간전", seconds / 60 / 60);
		} else {
			DateTimeFormatter pattern = DateTimeFormatter.ofPattern(includeHourMinute ? "yyyy-MM-dd HH:mm" : "yyyy-MM-dd");
			result = value.format(pattern);
		}
		return result;
	}
}
