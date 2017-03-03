package ru.javawebinar.topjava.web.meal;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.web.user.AbstractUserController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by User on 03.03.2017.
 */
@RestController
@RequestMapping("/ajax/profile/meals")
public class MealAjaxController extends AbstractMealController{
    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Meal get(int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }



}




