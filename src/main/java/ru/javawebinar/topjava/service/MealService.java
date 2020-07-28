package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFound;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

import java.util.Collection;

@Service
public class MealService {
    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(Meal meal) {
        return repository.save(meal);
    }

    public Meal get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public void delete(int id) {
       checkNotFoundWithId(repository.delete(id), id);
    }

    public Meal update(Meal meal) {
        return checkNotFound(repository.save(meal), meal.getId().toString());
    }

    public Collection<Meal> getAll() {
        return repository.getAll();
    }

}