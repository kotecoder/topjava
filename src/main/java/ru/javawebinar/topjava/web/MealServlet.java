package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by User on 13.12.2016.
 */
public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(UserServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to meals");
        request.setAttribute("meals", MealsUtil.getFilteredWithExceeded(MealsUtil.meals, LocalTime.MIN,LocalTime.MAX,MealsUtil.DEFAULT_CALORIES_PER_DAY));

        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}
