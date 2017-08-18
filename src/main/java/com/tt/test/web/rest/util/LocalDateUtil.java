package com.tt.test.web.rest.util;

import org.joda.time.LocalDate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class LocalDateUtil {

    private LocalDateUtil() {

    }

    public static LocalDate convertToLocalDate(String value) {

        List<Integer> temp = Arrays.asList(value.split("\\."))
            .stream()
            .map(e -> Integer.parseInt(e))
            .collect(Collectors.toList());

        return new LocalDate(temp.get(2), temp.get(1), temp.get(0));
    }
}
