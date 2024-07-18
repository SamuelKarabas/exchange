package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
@CrossOrigin(origins = "http://localhost:8082")

public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/rates")
    public String getExchangeRates() {
        return exchangeService.getExchangeRates();
    }
}
