package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;


import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class MealRestController {

    @Autowired
    private MealService service;

    public Meal save(Integer userId, Meal meal) {
        return service.save(userId, meal);
    }

    public boolean delete(Integer userId, int id){
        return service.delete(userId, id);
    }

    public Meal get(Integer userId, int id) {
        return service.get(userId, id);
    }

    public Collection<Meal> getAll(Integer userId) {
        return service.getAll(userId);
    }
}
