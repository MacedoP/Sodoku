package org.example;

import org.example.model.BoxDescription;
import org.example.model.SodukuMapVO;
import org.example.servicemap.excepition.MapParseException;
import org.example.servicemap.excepition.MapReadException;
import org.example.servicemap.excepition.MapValidationException;
import org.example.servicemap.map.MapParser.MapParser;
import org.example.servicemap.map.reader.MapReader;
import org.example.servicemap.map.reader.imp.BufferedReaderMapReader;
import org.example.servicemap.map.util.CollectionUtil;
import org.example.servicemap.map.util.MapUtil;
import org.example.servicemap.map.validator.MapValidator;
import org.example.servicemap.map.validator.impl.MapByBoxValidator;
import org.example.servicemap.map.validator.impl.MapByColumnValidator;
import org.example.servicemap.map.validator.impl.MapByRowValidator;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws MapParseException, MapReadException, MapValidationException {
        int[][] map ={
                {0,1},
                {2,3}
        };
        boolean[][] fixed = {
                {true,false},
                {false,true}
        };
        SodukuMapVO mapVO = new SodukuMapVO(2,2,map,fixed);
        System.out.println(mapVO);

       InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("./map/beginner.txt");
        //assert inputStream != null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        MapReader mapReader = new BufferedReaderMapReader(bufferedReader);
        List<String> strings = mapReader.readMap();
        System.out.println(strings);

        MapParser mapParser = new MapParser(9, 9);
        SodukuMapVO parseMap = mapParser.parseMap(strings);
        System.out.println(parseMap);

        CollectionUtil collectionUtil = new CollectionUtil();
        MapUtil mapUtil = new MapUtil();

        MapValidator mapByRowValidator = new MapByRowValidator(collectionUtil, mapUtil);
        MapValidator mapByColumnValidator = new MapByColumnValidator(collectionUtil, mapUtil);
        MapValidator mapByBoxValidator = new MapByBoxValidator(collectionUtil, mapUtil, BoxDescription.BOX_DESCRIPTION_LIST);

        mapByRowValidator.validate(parseMap);
        mapByColumnValidator.validate(parseMap);
        mapByBoxValidator.validate(parseMap);


        /*
        logger.trace("" )
        * */

         /*

        try {
            List<String> strings = mapReader.readMap();
            System.out.println(strings);

            MapParser mapParser = new MapParser(9, 9);
            SodukuMapVO parseMap = mapParser.parseMap(strings);
            System.out.println(parseMap);

            CollectionUtil collectionUtil = new CollectionUtil();
            MapUtil mapUtil = new MapUtil();

            MapValidator mapByRowValidator = new MapByRowValidator(collectionUtil, mapUtil);
            MapValidator mapByColumnValidator = new MapByColumnValidator(collectionUtil, mapUtil);
            MapValidator mapByBoxValidator = new MapByBoxValidator(collectionUtil, mapUtil, BoxDescription.BOX_DESCRIPTION_LIST);

            mapByRowValidator.validate(parseMap);
            mapByColumnValidator.validate(parseMap);
            mapByBoxValidator.validate(parseMap);
        } catch (MapReadException | MapParseException | MapValidationException e) {
            e.printStackTrace();
        }

         */

    }


}