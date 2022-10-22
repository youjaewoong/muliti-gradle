package cdp.common.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import cdp.common.util.StringUtil;


public class AlbatalkUserIdMaskingSerializer extends JsonSerializer<String> {
	@Override
	public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(StringUtil.toMaskingUserId(value));
	}
}
