package dev.allinone.libraryapp.controller.calculator;

import dev.allinone.libraryapp.controller.dto.calculator.request.CalculatorAddRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CalculatorController {

    @GetMapping("/add")
    int addTwoNumbers(CalculatorAddRequest request) {
        return request.number1() + request.number2();
    }
}
