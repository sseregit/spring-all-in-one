package dev.allinone.libraryapp.controller.calculator;

import dev.allinone.libraryapp.controller.dto.calculator.request.CalculatorAddRequest;
import dev.allinone.libraryapp.controller.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CalculatorController {

    @GetMapping("/add")
    int addTwoNumbers(CalculatorAddRequest request) {
        return request.number1() + request.number2();
    }

    @PostMapping("/multiply")
    int multiplyTwoNUmbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.number1() * request.number2();
    }
}
