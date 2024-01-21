package com.tagir.calculator.repositories;

import com.tagir.calculator.entity.Entity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalcRepository {

    private final List<Entity> allCalculations = new ArrayList<>();

    /**
     * Получить всю историю выполнения расчетов
     * @return Весь список ранее выполненных расчетов
     */
    public List<Entity> getAllCalculations(){
        return allCalculations;
    }

    /**
     * Добавление записи
     * @param entity запись с выполненным арифметическим расчетом
     */
    public void addCalculations(Entity entity){
        allCalculations.add(entity);
    }

}
