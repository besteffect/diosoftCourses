package com.diosoft.trsine.calendar.service;

import com.diosoft.trsine.calendar.common.Event;
import com.diosoft.trsine.calendar.datastore.DataStore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalendarServiceImpTest {

    @Test
    public void testAdd() throws Exception {
        // initialize variable inputs
        Event inputValue = new Event();

        // initialize mocks
        DataStore dataStore = mock(DataStore.class);

        // initialize class to test
        CalendarService testClass  = new CalendarServiceImp(dataStore);

        // invoke method on class to test
        testClass.add(inputValue);

        // assert return value

        // verify mock expectations
        verify(dataStore,times(2)).add(inputValue);

    }

    @Test
    public void testSearchByTitle() throws Exception {
        // initialize variable inputs
        Event expectedEvent = new Event();
        List<Event> expectedValue = Arrays.asList(expectedEvent);

        String inputValue = "Stand-up";

        // initialize mocks
        DataStore dataStore = mock(DataStore.class);

//        doThrow(new NullPointerException())
//
//                .when(dataStore).getEventsByTitle(inputValue);

        when(dataStore.getEventsByTitle(inputValue))
                .thenReturn(expectedValue);

        // initialize class to test
        CalendarService testClass  = new CalendarServiceImp(dataStore);

        // invoke method on class to test
        List<Event> returnedValue = testClass.searchByTitle(inputValue);

        // assert return value

        assertEquals(expectedValue,returnedValue);

        // verify mock expectations
    }

    @Test
    public void testRemove() throws Exception {
        // initialize variable inputs
        UUID inputValue = UUID.randomUUID();


        // initialize mocks

        // initialize class to test
        CalendarService calendarServiceImp = new CalendarServiceImp(null);
        CalendarService testClass = spy(calendarServiceImp);

        // invoke method on class to test
        testClass.remove(inputValue);

        // assert return value

        // verify mock expectations
        verify(testClass).logInfo(inputValue);

    }
}