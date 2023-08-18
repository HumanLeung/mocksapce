package com.example.mockspace.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDateTimeSerializer  extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String localDateTimeString = localDateTime.toLocalDate().toString() + " " + localDateTime.toLocalTime().toString();
        if (localDateTimeString.length() < 19){
            localDateTimeString += ":00";
        }
        jsonGenerator.writeString(localDateTimeString);
    }
}
