package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

/**
 * GKislin
 * 15.06.2015.
 */
public interface MealService {

    Meal save(Integer userId, Meal userMeal);

    boolean delete(Integer userId, int id);

    Meal get(Integer userId, int id);

    Collection<Meal> getAll(Integer userId);
}
