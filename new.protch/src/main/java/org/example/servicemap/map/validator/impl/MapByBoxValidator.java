package org.example.servicemap.map.validator.impl;

import org.example.model.BoxDescription;
import org.example.model.SodukuMapVO;
import org.example.servicemap.excepition.MapValidationException;
import org.example.servicemap.map.util.CollectionUtil;
import org.example.servicemap.map.util.MapUtil;
import org.example.servicemap.map.validator.MapValidator;

import java.util.List;

public class MapByBoxValidator implements MapValidator {

    private CollectionUtil collectionUtil;
    private MapUtil mapUtil;
    private List<BoxDescription> boxDescriptionList;

    public MapByBoxValidator(CollectionUtil collectionUtil, MapUtil mapUtil, List<BoxDescription> boxDescriptionList) {
        this.collectionUtil = collectionUtil;
        this.mapUtil = mapUtil;
        this.boxDescriptionList = boxDescriptionList;
    }

    @Override
    public void validate(SodukuMapVO mapVO) throws MapValidationException {
        for (BoxDescription boxDescription : boxDescriptionList) {
            List<Integer> boxValues = mapUtil.getBoxValues(mapVO, boxDescription);
            List<Integer> nonZeroValues = collectionUtil.getNonZeroValues(boxValues);

            if (!collectionUtil.containsOnlyDistinctValues(nonZeroValues)) {
                throw new MapValidationException("Boxes can only contain distinct values");
            }
        }
    }

}