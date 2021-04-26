package org.mano;

import org.mano.models.Movie;

import java.time.LocalDate;
import java.util.List;

public class App {

    public static void main(String[] args)
    {
        Movie movie = new Movie();
        movie.setTitle("The best movie");
        movie.setRating(8);
        movie.setRelDate(LocalDate.of(2017, 1, 13));

        MovieRepository repo = new MovieRepository();
        repo.add(movie);
        System.out.println("Added the movie" + movie.toString() );
        System.out.println("____________________________________");

        movie.setTitle("The second best movie");
        movie.setRating(7);
        movie.setRelDate(LocalDate.of(2012, 4, 12));

        repo.add(movie);

        System.out.println("Added the movie" + movie.toString() );
        System.out.println("____________________________________");

        Movie foundMovie ;

        foundMovie = repo.findByID(1);
        System.out.println("Founded the movie: " + foundMovie.toString());


       foundMovie =  repo.findByName("The best movie");
       System.out.println("Founded the movie: " + foundMovie.toString());

       // List<Movie> theTop = repo.ratingChart();
        ratingChart theTop = repo.ratingChart();
        System.out.println("Top generated at: " + theTop.getgeneratedDate());
        for(int i = 0; i < theTop.result.size() ; i++)
            System.out.println( theTop.result.get(i).toString() );

        /*List<Movie> theotherTop = repo.ratingChart(1);
        for(int i = 0; i < theotherTop.size() ; i++)
            System.out.println( theTop.get(i).toString() );
*/
        repo.close();


    }

}
