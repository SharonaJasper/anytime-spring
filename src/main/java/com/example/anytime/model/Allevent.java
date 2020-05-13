package com.example.anytime.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
public class Allevent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idevent;

    String eventname;
    String eventlocation;
    String eventdescription;
    Date eventdate = new Date();
    String eventdateformatted = "00-00-0000";

    public Allevent() {}

    public Allevent(int idevent, String eventname, String eventlocation, String eventdescription, Date eventdate) {
        this.idevent = idevent;
        this.eventname = eventname;
        this.eventlocation = eventlocation;
        this.eventdescription = eventdescription;
        this.eventdate = eventdate;
        this.eventdateformatted = eventdateformatted;
    }

    public int getIdevent() {
        return idevent;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventlocation() {
        return eventlocation;
    }

    public void setEventlocation(String eventlocation) {
        this.eventlocation = eventlocation;
    }

    public String getEventdescription() {
        return eventdescription;
    }

    public void setEventdescription(String eventdescription) {
        this.eventdescription = eventdescription;
    }

    public Date getEventdate() {
        return eventdate;
    }

    public void setEventdate(Date evendate) {
        this.eventdate = evendate;
    }

    public String getEventdateformatted() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String eventdateformatted = dateFormat.format(eventdate);
        return eventdateformatted;
    }

     public void setEventdateformatted(String eventdateformatted) {
        this.eventdateformatted = eventdateformatted;
    }

    @Override
    public String toString() {
        return "[Allevent: " +
                "[" + "idevent: " + idevent +
                ", " + "eventname: " + eventname +
                ", " + "eventlocation: " + eventlocation +
                ", " + "eventdescription: " + eventdescription +
                ", " + "eventdate: " + eventdate +
                ", " + "eventdateformatted: " + eventdateformatted + "]";
    }
}
