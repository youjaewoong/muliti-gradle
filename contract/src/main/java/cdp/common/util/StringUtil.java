package cdp.common.util;

public class StringUtil {
	public static String toMaskingUserId(String userId) {
		return userId.replaceAll("((?!.{4}).)((?!.{3}).)", "**");
	}
}
