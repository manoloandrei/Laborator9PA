package org.mano;


import org.mano.models.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class MovieRepository {


    private EntityManager entityManager;
    EntityManagerFactory entityManagerFactory;
    long myID =0;

    public MovieRepository(){
        this.entityManagerFactory= Persistence.createEntityManagerFactory("moviePU");

    }

    public void add(Movie movie)
    {
        this.entityManager = entityManagerFactory.createEntityManager();
        movie.setId(myID); myID ++;
        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.getTransaction().commit();

        this.entityManager.close();

    }


    public Movie findByID (long id)
    {
        this.entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNamedQuery("Find movie by id");
        query.setParameter("id", id);

        return (Movie) query.getSingleResult();

    }

    public Movie findByName (String title)
    {
        this.entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNamedQuery("Find movie by title");
        query.setParameter("title", title);

        return (Movie) query.getSingleResult();


    }

    public ratingChart ratingChart() {
        Query query = entityManager.createQuery("Select m from Movie m order by m.rating desc");
        ratingChart toReturn = new ratingChart();



        toReturn.result = query.getResultList();
        return toReturn;
       // return query.getResultList();
    }

    public List<Movie> ratingChart(int period) {
        Query query = entityManager.createQuery("Select m from Movie m where Movie.releaseDate between '1990-01-01' and '2020-03-01' order by m.rating desc");
        return query.getResultList();
    }

    public void close(){

        this.entityManagerFactory.close();
    }


}
