package org.academiadecodigo.bootcamp.model.dao;

import org.hibernate.Query;

import java.util.List;

/**
 * Created by codecadet on 06/07/16.
 */
public interface Dao<T> {

    boolean authenticate(String string, String string2);

    void save(T user);

    T findByName(String string);

    List<T> findMany(Query query);

    int count();

    void delete(T Dao);
}
