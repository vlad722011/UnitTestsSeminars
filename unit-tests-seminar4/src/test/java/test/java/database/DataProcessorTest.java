package database;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

class DataProcessorTest {

    @Test
    void testDB() {
        Database database = mock(Database.class);
        when(database.query(anyString())).thenReturn(Arrays.asList("testa", "testb", "testc"));
        DataProcessor dataProcessor = new DataProcessor(database);

        assertThat(dataProcessor.processData("SELECT * FROM users WHERE username LIKE '%test%' ").size()).isEqualTo(3);

    }

}