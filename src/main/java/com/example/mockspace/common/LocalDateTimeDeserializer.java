package com.example.mockspace.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.core.JsonToken.VALUE_STRING;

/**
 * iuap前端restful请求epoch millisecond转为LocalDateTime
 * 同时兼容yyyy-MM-dd HH:mm:ss和LocalDateTime默认格式转为LocalDateTime
 * @author lanjzh
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (VALUE_STRING.equals(jsonParser.getCurrentToken())) {
            String jsonParserStr = jsonParser.getValueAsString();
            if (jsonParser.getValueAsString().length() <= 10) {
                jsonParserStr += "T00:00";
            }
            if (jsonParserStr.contains("T")) {
                return LocalDateTime.parse(jsonParserStr);
            }
            return LocalDateTime.parse(jsonParserStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
        return Instant.ofEpochMilli(jsonParser.getLongValue()).atZone(ZoneId.of("+8")).toLocalDateTime();
    }
}
