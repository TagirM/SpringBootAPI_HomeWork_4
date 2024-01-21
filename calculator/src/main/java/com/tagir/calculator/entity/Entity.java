package com.tagir.calculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entity {
    //Первое число
    double firstNumber;
    //Второе число
    double secondNumber;
    //Знак арифметической операции
    char operation;
    //Результат вычисления
    double result;
}
