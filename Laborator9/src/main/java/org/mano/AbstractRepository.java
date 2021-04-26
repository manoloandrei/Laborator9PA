package org.mano;

import org.mano.models.Movie;

public interface AbstractRepository<T> {

    public void add(T entity);

}
