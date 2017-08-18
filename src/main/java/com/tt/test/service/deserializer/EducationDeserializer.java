package com.tt.test.service.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.tt.test.domain.EducationEntity;
import com.tt.test.web.rest.util.LocalDateUtil;
import org.joda.time.LocalDate;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class EducationDeserializer extends JsonDeserializer<Set<EducationEntity>> {
    @Override
    public Set<EducationEntity> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Set<EducationEntity> collection = new HashSet<>();
        LocalDate educationStartDate;
        LocalDate educationEndDate;

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        for(JsonNode n : node) {

            educationStartDate = LocalDateUtil.convertToLocalDate(n.get("educationStartDate").asText());
            educationEndDate = LocalDateUtil.convertToLocalDate(n.get("educationEndDate").asText());

            collection.add(new EducationEntity(
                null,
                educationStartDate,
                educationEndDate,
                n.get("isLearning").asBoolean(),
                n.get("schoolName").asText(),
                n.get("subject").asText(),
                n.get("educationDescription").asText(),
                null
            ));
        }

        return collection;
    }
}
