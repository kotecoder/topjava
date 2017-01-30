package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.DateTimeUtil;

import java.time.LocalDateTime;

import static ru.javawebinar.topjava.model.BaseEntity.START_SEQ;

/**
 * GKislin
 * 13.03.2015.
 */
public class MealTestData {
    public static final int MEAL_ID = START_SEQ+2;


    public static final Meal USER_BREACKFAST = new Meal (MEAL_ID, LocalDateTime.of(2017,01,02,8,13),"omlet",300);
    public static final Meal USER_LUNCH = new Meal (MEAL_ID, LocalDateTime.of(2017,01,02,14,13),"potato",300);
    public static final Meal USER_DINNER =new Meal (MEAL_ID, LocalDateTime.of(2017,01,02,20,13),"chicken",400);


    public static final ModelMatcher<Meal> MATCHER = new ModelMatcher<>();


}
