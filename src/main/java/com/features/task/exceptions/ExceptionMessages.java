package com.features.task.exceptions;

public interface ExceptionMessages {
    String NOT_FOUND_MESSAGE = "Feature is not found by id %s";

    static String of(String msg, Object ... args) {
        return String.format(msg, args);
    }
}
