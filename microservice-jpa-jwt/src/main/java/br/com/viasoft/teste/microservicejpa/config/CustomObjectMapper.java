package br.com.viasoft.teste.microservicejpa.config;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.util.Date;

public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper() {
        SimpleModule module = new SimpleModule("estatistica", Version.unknownVersion());
        module.addDeserializer(Date.class, new LocalDateDeserializer());
        module.addSerializer(Date.class, new LocalDateSerializer());
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        super.registerModule(module);
    }

}