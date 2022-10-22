package cdp.common.util;

import org.apache.commons.lang3.StringUtils;

public class NickNameUtil {
	public static String toDisplayNickName(String userId, String nickName) {
		return StringUtils.isEmpty(nickName) ? StringUtil.toMaskingUserId(userId) : nickName;
	}
}
