package org.example.servicemap.map.reader.imp;

import org.example.servicemap.excepition.MapReadException;
import org.example.servicemap.map.reader.MapReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferedReaderMapReader implements MapReader {

    private final BufferedReader bufferedReader;

    public BufferedReaderMapReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public List<String> readMap() throws MapReadException {//throws MapReadException {
        String line;
        List<String> result = new ArrayList<>();
        //InputStream inputStream = null;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            throw new MapReadException("Failed to read map");
        }

        return result;
    }

}