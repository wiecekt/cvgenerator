package com.tt.test.service.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.tt.test.domain.HistoryExperienceEntity;
import com.tt.test.web.rest.util.LocalDateUtil;
import org.joda.time.LocalDate;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class HistoryExperienceDeserializer extends JsonDeserializer<Set<HistoryExperienceEntity>> {

    @Override
    public Set<HistoryExperienceEntity> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Set<HistoryExperienceEntity> collection = new HashSet<>();
        LocalDate historyStartDate;
        LocalDate historyEndDate;

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        for(JsonNode n : node) {

            historyStartDate = LocalDateUtil.convertToLocalDate(n.get("historyStartDate").asText());
            historyEndDate = LocalDateUtil.convertToLocalDate(n.get("historyEndDate").asText());

            collection.add(new HistoryExperienceEntity(
                null,
                historyStartDate,
                historyEndDate,
                n.get("isWorking").asBoolean(),
                n.get("companyName").asText(),
                n.get("position").asText(),
                n.get("historyDescription").asText(),
                null
            ));
        }

        return collection;
    }
}
