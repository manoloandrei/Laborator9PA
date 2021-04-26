package org.mano;

import org.mano.models.Movie;

import java.time.LocalDate;
import java.util.List;

public class ratingChart {
    public List<Movie> result;
    private LocalDate generatedDate = LocalDate.now();

    public LocalDate getgeneratedDate() {
        return generatedDate;
    }

    public void setgeneratedDate(LocalDate generatedDate) {
        this.generatedDate = generatedDate;
    }
}
