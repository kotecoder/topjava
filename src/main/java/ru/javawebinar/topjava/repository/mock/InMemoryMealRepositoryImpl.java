package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * GKislin
 * 15.09.2015.
 */

@Repository
public class InMemoryMealRepositoryImpl implements MealRepository {
    private static final Logger LOG = LoggerFactory.getLogger(InMemoryMealRepositoryImpl.class);

    private Map<Integer, Map<Integer, Meal>> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.USER_LIST.forEach(user -> MealsUtil.MEALS.forEach(
                userMeal -> save(user.getId(), userMeal)
        ));

    }


    @Override
    public Meal save(Integer userId, Meal meal) {
        LOG.info("save " + meal);
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
        }
        repository.put(userId, new ConcurrentHashMap<Integer, Meal>() {{
            put(meal.getId(), meal);
        }});
        return meal;


    }


    @Override
    public boolean delete(Integer userId, int id) {
        LOG.info("delete " + id);
        Map<Integer, Meal> userMeals = repository.get(userId);
        return userMeals != null && userMeals.remove(id) != null;
    }

    @Override
    public Meal get(Integer userId, int id) {
        LOG.info("get " + id);
        Map<Integer, Meal> userMeals = repository.get(userId);
        return userMeals == null ? null : userMeals.get(id);
    }


    public Collection<Meal> getAll(Integer userId) {
        LOG.info("getAll");
        Map<Integer, Meal> userMeals = repository.get(userId);
        return userMeals == null ?
                Collections.emptyList() :
                userMeals.values().stream()
                        .sorted((meal, anotherMeal) -> anotherMeal.getDateTime().compareTo(meal.getDateTime()))
                        .collect(Collectors.toList());

    }
}

