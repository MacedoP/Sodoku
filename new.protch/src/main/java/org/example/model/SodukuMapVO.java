package org.example.model;

import java.util.Arrays;
import java.util.Objects;

public class SodukuMapVO {
    private final int numberOfRows;
    private final int numberOfColumns;
    private final int[][] map;
    private final boolean[][] fixed;

    public SodukuMapVO(int numberOfRows, int numberOfColumns, int[][] map, boolean[][] fixed) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.map = map;
        this.fixed = fixed;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int[][] getMap() {
        return map;
    }

    public boolean[][] getFixed() {
        return fixed;
    }
    private int[][] deepCopy(int[][] mapTocopy) {
        int[][] result = new int[mapTocopy.length][];

        for (int i = 0; i < mapTocopy.length; i++) {
            result[i] = new int[mapTocopy[i].length];
            for (int j = 0; j < mapTocopy[i].length; j++) {
                result[i][j] = mapTocopy[i][j];
            }
        }

        return result;
    }
    private boolean[][] deepCopy(boolean[][] map) {
        boolean[][] result = new boolean[map.length][];

        for (int i = 0; i < map.length; i++) {
            result[i] = new boolean[map[i].length];
            for (int j = 0; j < map[i].length; j++) {
                result[i][j] = map[i][j];
            }
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SodukuMapVO mapVO = (SodukuMapVO) o;
        return numberOfRows == mapVO.numberOfRows && numberOfColumns == mapVO.numberOfColumns && Arrays.deepEquals(map, mapVO.map) && Arrays.deepEquals(fixed, mapVO.fixed);
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfRows, numberOfColumns);
        result = 31 * result + Arrays.deepHashCode(map);
        result = 31 * result + Arrays.deepHashCode(fixed);
        return result;
    }

    @Override
    public String toString() {
        return "MapVO{" +
                "numberOfRows=" + numberOfRows +
                ", numberOfColumns=" + numberOfColumns +
                ", map=" + Arrays.deepToString(map) +
                ", fixed=" + Arrays.deepToString(fixed) +
                '}';
    }

}
