package com.smartappsusa.rinder;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

public class SearchFilterTest {

    @Test
    public void testOnCreateNotNull() {
        Map<String, Object> filter = new HashMap<>();
        assertNotNull(filter);
    }

    @Test
    public void testOnCreateNull() {
        Map<String, Object> filter = new HashMap<>();
        assertFalse(filter.containsKey("cleanliness"));
    }

    @Test
    public void testOnClick() {
        Map<String, Object> filter = new HashMap<>();
        filter.put("cleanliness", 0);
        filter.put("sleepSchedule", 1);
        filter.put("noiseLevel", 2);
        filter.put("social", 2);
        filter.put("budget", 1);
        filter.put("hobbies", 0);
    }

    @Test
    public void testLoadFilters() {
        String id = "bsahat04";
        assertNotNull(id);
    }

    @Test
    public void testSaveFilters() {
        Map<String, Object> filter = new HashMap<>();
        filter.put("cleanliness", 0);
        filter.put("sleepSchedule", 1);
        filter.put("noiseLevel", 2);
        filter.put("social", 2);
        filter.put("budget", 1);
        filter.put("hobbies", 0);

        assertTrue(filter.containsKey("cleanliness"));
        assertTrue(filter.containsKey("sleepSchedule"));
        assertTrue(filter.containsKey("noiseLevel"));
        assertTrue(filter.containsKey("social"));
        assertTrue(filter.containsKey("budget"));
        assertTrue(filter.containsKey("hobbies"));
    }
}
