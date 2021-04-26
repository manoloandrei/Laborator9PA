package org.mano.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "movie")
@NamedQueries({
        @NamedQuery(name = "Find movie by id", query = "select m from Movie m where m.id = :id"),
        @NamedQuery(name = "Find movie by title", query = "select m from Movie m where m.title = :title ")
})
public class Movie {

    @Id
    @Column(name = "id", unique = true)
    private long id;

    @Column(name = "title", nullable = false, length = 70)
    private String title;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "releaseDate")
    private LocalDate relDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getRelDate() {
        return relDate;
    }

    public void setRelDate(LocalDate relate) {
        this.relDate = relDate;
    }

    @Override
    public String toString(){
        return "Movie: ID= " + id + " Title= " + title;
    }

}

