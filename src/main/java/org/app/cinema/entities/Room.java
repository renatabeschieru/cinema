package org.app.cinema.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Room extends BaseEntity implements Serializable, Comparable<Room> {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int nrOfSeats;

    private int nrOfRows;

    private Movie movie;

    public Room(String name, int nrOfSeats, int nrOfRows) {
        this.name = name;
        this.nrOfSeats = nrOfSeats;
        this.nrOfRows = nrOfRows;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(int nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    public int getNrOfRows() {
        return nrOfRows;
    }

    public void setNrOfRows(int nrOfRows) {
        this.nrOfRows = nrOfRows;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return nrOfSeats == room.nrOfSeats &&
                nrOfRows == room.nrOfRows &&
                Objects.equals(id, room.id) &&
                Objects.equals(name, room.name) &&
                Objects.equals(movie, room.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nrOfSeats, nrOfRows, movie);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nrOfSeats=" + nrOfSeats +
                ", nrOfRows=" + nrOfRows +
                ", movie=" + movie +
                '}';
    }

    @Override
    public int compareTo(Room o) {
        return 0;
    }
}
