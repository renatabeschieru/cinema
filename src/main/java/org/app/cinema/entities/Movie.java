package org.app.cinema.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Movie extends BaseEntity implements Serializable, Comparable<Movie> {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String releaseDate;

    @ManyToMany
    private List<Director> directors;

    @ManyToMany
    private List<Actor> actors;

    public Movie(String name, String releaseDate) {
        actors = new ArrayList<>();
        directors = new ArrayList<>();
        this.name = name;
        this.releaseDate = releaseDate;
    }

    @Override
    public int compareTo(Movie o) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void addDirector(Director director) {
        this.directors.add(director);
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) &&
                Objects.equals(releaseDate, movie.releaseDate) &&
                Objects.equals(directors, movie.directors) &&
                Objects.equals(actors, movie.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, releaseDate, directors, actors);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name=" + name +
                "id=" + id +
                ", releaseDate=" + releaseDate +
                ", directors=" + directors +
                ", actors=" + actors +
                '}';
    }
}
