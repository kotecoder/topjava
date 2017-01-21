package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
public interface MealRepository {
    Meal save(Integer userId,Meal Meal);

    boolean delete(Integer userId,int id);

    Meal get(Integer userId,int id);

    Collection<Meal> getAll(Integer userId);


}
