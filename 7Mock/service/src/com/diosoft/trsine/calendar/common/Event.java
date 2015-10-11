package com.diosoft.trsine.calendar.common;

import java.util.Date;
import java.util.List;

// Создать Event Pojo объект  (в соответстви Builder паттерн): DONE
// должен содержать поле String description DONE
// должен содержать поле List<String> attenders DONE
// должен содержать поле Date date (время евента) DONE
// Cоздать Main класс который будет содержать main  метод принимающий на вход список descriptions для создания событий (Event) и добавляющий их в хранилище. main метод должен заполнять предопределенные событиея списком приглашенных участников (emails)
// Создать класс CallendarService который будет отвечать за создание и обслуживание евентов нашего календаря
// внутри сервиса вы должны содержать хранилище всех событий в виде HashMap
// добавте метод для добавленния события в календарь addEvent(event)
// добавте метод для удобного создания событий createEvent(title, emails)
// добавте метод для поиска события по title Event  searac(title: String)
// функционал должен быть протестирован с помощью юнит тестов
public class Event {
    private final String description;
    private final List<String> attenders;
    private final Date date;

    private Event( Builder builder){
        this.description=builder.description;
        this.attenders=builder.attenders;
        this.date=builder.date;

    }

    public String getDescription() {
        return description;
    }

    public List<String> getAttenders() {
        return attenders;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (!attenders.equals(event.attenders)) return false;
        if (!date.equals(event.date)) return false;
        if (!description.equals(event.description)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
        result = 31 * result + attenders.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "description='" + description + '\'' +
                ", attenders=" + attenders +
                ", date=" + date +
                '}';
    }

    public static class Builder{
        private String description;
        private List<String> attenders;
        private Date date;

        public Builder(){
        }

        public Builder(Event original){
            this.description=original.description;
            this.attenders=original.attenders;
            this.date=original.date;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder attenders(List<String> attenders){
            this.attenders = attenders;
            return this;
        }

        public Builder date (Date date){
            this.date = date;
            return this;
        }
        public Event build(){
            return new Event(this);
        }
    }
}
