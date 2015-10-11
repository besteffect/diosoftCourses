package com.diosoft.trsine.calendar.service;

import com.diosoft.trsine.calendar.common.Event;
import com.diosoft.trsine.calendar.datastore.DataStore;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CalendarServiceImp implements CalendarService {

    private final DataStore dataStore;

    public CalendarServiceImp(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void add(Event event) {
        dataStore.add(event);
        dataStore.add(event);

    }

    @Override
    public void remove(UUID id) {
        logInfo(id);

    }

    @Override
    public void logInfo(UUID id) {
        System.out.println(id);

    }

    @Override
    public List<Event> searchByTitle(String title) {
        return dataStore.getEventsByTitle(title);
    }

    @Override
    public List<Event> searchByDay(Date day) {
        return null;
    }
}
