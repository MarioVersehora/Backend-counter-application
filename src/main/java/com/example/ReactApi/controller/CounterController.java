package com.example.ReactApi.controller;

import com.example.ReactApi.model.Counter;
import com.example.ReactApi.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("counter")
public class CounterController {

    private final CounterService counterService;

    @PostMapping("decrement/{counterId}")
    public Counter decrementCounter(@PathVariable Integer counterId) {
        return counterService.decrementCounter(counterId);
    }

    @PostMapping("increment/{counterId}")
    public Counter incrementCounter(@PathVariable Integer counterId) {
        return counterService.incrementCounter(counterId);
    }

    @GetMapping("{counterId}")
    public Counter getCounterById(@PathVariable Integer counterId) {
        return counterService.getCounterById(counterId);
    }

    @PostMapping
    public Counter saveCounter() {
        return counterService.saveCounter();
    }



}
