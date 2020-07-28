package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalTime;
import java.util.List;

@Controller
public class MealRestController {
    private static final Logger log = LoggerFactory.getLogger(MealRestController.class);

    private final MealService service;

    public MealRestController(MealService service) {
        this.service = service;
    }

    public List<MealTo> getAll() {
        return MealsUtil.getTos(service.getAll(), MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

    public List<MealTo> getMealForSelectedTime(LocalTime startTime, LocalTime endTime) {
        return MealsUtil.getFilteredTos(service.getAll(), MealsUtil.DEFAULT_CALORIES_PER_DAY, startTime, endTime);
    }

    public Meal create(Meal meal) {
        log.info("create {}", meal);
        return service.create(meal);
    }

    public Meal update(Meal meal) {
        return service.update(meal);
    }

    public void delete(int id) {
        service.delete(id);
    }

    public Meal get(int id) {
        return service.get(id);
    }
}