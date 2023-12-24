package org.example.servicemap.map.validator.impl;

import java.util.List;

import org.example.model.SodukuMapVO;
import org.example.servicemap.excepition.MapValidationException;
import org.example.servicemap.map.util.CollectionUtil;
import org.example.servicemap.map.util.MapUtil;
import org.example.servicemap.map.validator.MapValidator;

public class MapByRowValidator implements MapValidator {

    private CollectionUtil collectionUtil;
    private MapUtil mapUtil;

    public MapByRowValidator(CollectionUtil collectionUtil, MapUtil mapUtil) {
        this.collectionUtil = collectionUtil;
        this.mapUtil = mapUtil;
    }

    @Override
    public void validate(SodukuMapVO mapVO) throws MapValidationException {
        for (int i = 0; i < mapVO.getNumberOfRows(); i++) {
            List<Integer> row = mapUtil.getRowWithIndex(mapVO, i);
            List<Integer> nonZeroValues = collectionUtil.getNonZeroValues(row);

            if (!collectionUtil.containsOnlyDistinctValues(nonZeroValues)) {
                throw new MapValidationException("Rows can only contain distinct values");
            }
        }
    }

}