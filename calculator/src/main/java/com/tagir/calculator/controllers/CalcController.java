package com.tagir.calculator.controllers;

import com.tagir.calculator.entity.Entity;
import com.tagir.calculator.services.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculator")
public class CalcController {
    @Autowired
    private CalcService calcService;

    /**
     * Начальная страница с историей расчетов
     * @param model модель в thymeleaf
     * @return страница приложения
     */
    @GetMapping
    public String inputData(Model model){
        model.addAttribute("entities", calcService.getAllCalculations());
        return "calcPage";
    }

    /**
     * Получение результата расечта
     * @param entity введенные данные в форме в thymeleaf
     * @param model модель в thymeleaf
     * @return страница приложения с результатом
     */
    @PostMapping
    public String resulting(Entity entity, Model model){
        model.addAttribute("entities", calcService.getAllCalculations());
        model.addAttribute("result", calcService.calculate(entity.getFirstNumber(), entity.getSecondNumber(), entity.getOperation()));
        return "calcPage";
    }
}
