package org.mano;

import org.mano.models.Movie;

import java.time.LocalDate;

public class JDBCTest {

    public static void main(String[] args) {

        JDBCUtil obj = JDBCUtil.getInstance("org.postgresql.Driver","jdbc:postgresql://localhost:5432/postgres","postgres","admin");
        obj.getConnection();
        Movie movie = new Movie();
        movie.setId(23);
        movie.setRating(10);
        movie.setRelDate(LocalDate.of(2011, 1, 23));
        movie.setTitle("Avatar");
        obj.add(movie);
        obj.queryTest();
        obj.findByID(23);
        obj.findByName("Avatar");
    }

}
