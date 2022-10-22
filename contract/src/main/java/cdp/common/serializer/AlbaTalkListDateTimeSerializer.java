package cdp.common.serializer;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import cdp.common.util.LocalDateTimeUtil;

public class AlbaTalkListDateTimeSerializer extends JsonSerializer<LocalDateTime> {
	@Override
	public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(LocalDateTimeUtil.toDateDisplay(value));
	}
}