package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class MealServiceImpl implements MealService {



    @Autowired
    private MealRepository repository;

    @Override
    public Meal save(Integer userId, Meal meal) {
        return repository.save(userId, meal);
    }

    @Override
    public boolean delete(Integer userId, int id) {
        return repository.delete(userId, id);
    }

    @Override
    public Meal get(Integer userId, int id) {
        return repository.get(userId, id);
    }

    @Override
    public Collection<Meal> getAll(Integer userId) {
        return repository.getAll(userId);
    }

}
