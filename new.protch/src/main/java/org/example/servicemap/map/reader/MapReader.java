package org.example.servicemap.map.reader;
import org.example.servicemap.excepition.MapReadException;

import java.util.List;

public interface MapReader {

    List<String> readMap() throws MapReadException;

}