package org.example.servicemap.map.util;

import java.util.ArrayList;
import java.util.List;

import org.example.model.BoxDescription;
import org.example.model.SodukuMapVO;

public class MapUtil {

    public List<Integer> getRowWithIndex(SodukuMapVO mapVO, int rowIndex) {
        List<Integer> result = new ArrayList<>();

        int[][] map = mapVO.getMap();
        for (int i = 0; i < mapVO.getNumberOfColumns(); i++) {
            result.add(map[rowIndex][i]);
        }

        return result;
    }

    public List<Integer> getColumnWithIndex(SodukuMapVO mapVO, int columnIndex) {
        List<Integer> result = new ArrayList<>();

        int[][] map = mapVO.getMap();
        for (int i = 0; i < mapVO.getNumberOfRows(); i++) {
            result.add(map[i][columnIndex]);
        }

        return result;
    }

    public List<Integer> getBoxValues(SodukuMapVO mapVO, BoxDescription boxDescription) {
        List<Integer> result = new ArrayList<>();

        int[][] map = mapVO.getMap();
        int minRowIndex = boxDescription.getMinRowIndex();
        int maxRowIndex = boxDescription.getMaxRowIndex();
        int minColumnIndex = boxDescription.getMinColumnIndex();
        int maxColumnIndex = boxDescription.getMaxColumnIndex();

        for (int i = minRowIndex; i < maxRowIndex; i++) {
            for (int j = minColumnIndex; j < maxColumnIndex; j++) {
                result.add(map[i][j]);
            }
        }

        return result;
    }

}