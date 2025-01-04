package dev.keith.event;

import dev.keith.IDataBase;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public record Parameters(BufferedReader reader, BufferedWriter writer, IDataBase<?, ?, ?> source) {
    public void cancelAction() {
        Thread.currentThread().interrupt();
    }
}
