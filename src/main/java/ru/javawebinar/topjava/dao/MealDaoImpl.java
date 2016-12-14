package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by User on 14.12.2016.
 */
public class MealDaoImpl implements MealDao {
    private Map<Integer, Meal> dbInMemory = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.meals.forEach(this::save);
    }

    @Override
    public Meal save(Meal meal) {
        if (meal.getId()== null) {
            meal.setId(counter.incrementAndGet());
        }
        return dbInMemory.put(meal.getId(), meal);
    }

    @Override
    public void delete(int id) {
        dbInMemory.remove(id);
    }

    @Override
    public Meal getById(int id) {
      return   dbInMemory.get(id);

    }

    @Override
    public Collection<Meal> getAll() {
       return dbInMemory.values();

    }
}
