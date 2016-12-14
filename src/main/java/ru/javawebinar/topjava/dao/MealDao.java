package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

/**
 * Created by User on 14.12.2016.
 */
public interface MealDao {
    Meal save(Meal meal);

    void delete(int id);

    Meal getById(int id);

    Collection<Meal> getAll();
}
