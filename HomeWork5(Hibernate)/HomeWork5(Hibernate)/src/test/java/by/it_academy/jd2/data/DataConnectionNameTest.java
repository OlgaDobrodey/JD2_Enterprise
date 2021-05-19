package by.it_academy.jd2.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DataConnectionNameTest {

    @Test
    void values() {
        DataConnectionName[] valuesEx = DataConnectionName.values();
        DataConnectionName[] valuesAc = new DataConnectionName[]{DataConnectionName.POSTGRES, DataConnectionName.HIBERNATE};
        assertArrayEquals(valuesEx, valuesAc);


    }

    @Test
    void valueOf() {
        DataConnectionName postgres = DataConnectionName.valueOf("POSTGRES");
        assertEquals(postgres, DataConnectionName.POSTGRES);

    }
}