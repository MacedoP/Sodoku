package org.example.servicemap.map.validator;
import org.example.model.SodukuMapVO;
import org.example.servicemap.excepition.MapValidationException;

public interface MapValidator {

    void validate(SodukuMapVO mapVO) throws MapValidationException;

}