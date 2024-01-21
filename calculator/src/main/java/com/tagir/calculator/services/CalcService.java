package com.tagir.calculator.services;

import com.tagir.calculator.entity.Entity;
import com.tagir.calculator.repositories.CalcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcService {

    private final CalcRepository calcRepository;

    public CalcService(CalcRepository calcRepository) {
        this.calcRepository = calcRepository;
    }

    /**
     * Выполнение арифметической операции
     * @param firstNumber Первое число
     * @param secondNumber Второе число
     * @param operation Арифметическая операция
     * @return Результат арифметической операции
     */

    public double calculate(double firstNumber, double secondNumber, char operation){
        Entity entity = new Entity();
        double result = 0;
        switch (operation) {
            case ('+') :
                result = firstNumber + secondNumber;
                break;
            case ('-') :
                result = firstNumber - secondNumber;
                break;
            case ('*') :
                result = firstNumber * secondNumber;
                break;
            case ('/') :
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                }
                else throw new RuntimeException("Division by zero!");
        };
        entity.setFirstNumber(firstNumber);
        entity.setSecondNumber(secondNumber);
        entity.setOperation(operation);
        entity.setResult(result);
        calcRepository.addCalculations(entity);
        return result;
    }

    /**
     * Получить всю историю выполнения расчетов
     * @return Весь список ранее выполненных расчетов
     */
    public List<Entity> getAllCalculations(){
        return calcRepository.getAllCalculations();
    }
}
