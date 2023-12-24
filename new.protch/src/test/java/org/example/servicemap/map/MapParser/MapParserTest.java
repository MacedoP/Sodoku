package org.example.servicemap.map.MapParser;

import org.example.model.SodukuMapVO;
import org.example.servicemap.excepition.MapParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

class MapParserTest {

    private static final int NUMBER_OF_ROWS = 2;
    private static final int NUMBER_OF_COLUMNS = 2;

    private static final List<String> RAW_MAP = List.of(
            "01",
            "20"
    );
    private static final List<String> MAP_WITH_FEWER_ROWS = List.of(
            "01"
    );
    private static final int[][] MAP = {
            {0, 1},
            {2, 0}
    };
    private static final boolean[][] FIXED = {
            {false, true},
            {true, false}
    };

    private static final SodukuMapVO EXPECTED_MAP = new SodukuMapVO(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS, MAP, FIXED);

    private MapParser underTest;

    @BeforeEach
    public void setUp() {
        underTest = new MapParser(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
    }

    @Test
    public void testParseMapShouldReturnValidMapVoRepresentation() throws MapParseException {
        // given in setup
        // when
        SodukuMapVO result = underTest.parseMap(RAW_MAP);
        // then
        assertEquals(EXPECTED_MAP, result);
    }
}