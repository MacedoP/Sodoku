package org.example.servicemap.map.validator.impl;

import org.example.model.SodukuMapVO;
import org.example.servicemap.excepition.MapValidationException;
import org.example.servicemap.map.util.CollectionUtil;
import org.example.servicemap.map.util.MapUtil;
import org.example.servicemap.map.validator.MapValidator;

import java.util.List;



public class MapByColumnValidator implements MapValidator {

    private CollectionUtil collectionUtil;
    private MapUtil mapUtil;

    public MapByColumnValidator(CollectionUtil collectionUtil, MapUtil mapUtil) {
        this.collectionUtil = collectionUtil;
        this.mapUtil = mapUtil;
    }

    @Override
    public void validate(SodukuMapVO mapVO) throws MapValidationException {
        for (int i = 0; i < mapVO.getNumberOfColumns(); i++) {
            List<Integer> column = mapUtil.getColumnWithIndex(mapVO, i);
            List<Integer> nonZeroValues = collectionUtil.getNonZeroValues(column);

            if (!collectionUtil.containsOnlyDistinctValues(nonZeroValues)) {
                throw new MapValidationException("Columns can only contain distinct values");
            }
        }
    }

}