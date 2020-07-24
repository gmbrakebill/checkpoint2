package com.galvanize.flight_log;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@ManyToOne(targetEntity = Pilot.class)
    //
    @Column(columnDefinition = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    //
    @Column(name = "local_time", columnDefinition = "TIME")
    private Time time;
    private int planeNumber;
    private String flightOrigin;
    private String pilotNotes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }
    private int pilot;

    public int getPilot() {
        return pilot;
    }

    public void setPilot(int pilot) {
        this.pilot = pilot;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Time getTime() {
        return time;
    }
    public void setTime(Time time) {
        this.time = time;
    }

    public int getPlaneNumber() {
        return planeNumber;
    }

    public void setPlaneNumber(int planeNumber) {
        this.planeNumber = planeNumber;
    }

    public String getFlightOrigin() {
        return flightOrigin;
    }

    public void setFlightOrigin(String flightOrigin) {
        this.flightOrigin = flightOrigin;
    }


    public String getPilotNotes() {
        return pilotNotes;
    }

    public void setPilotNotes(String pilotNotes) {
        this.pilotNotes = pilotNotes;
    }
}
