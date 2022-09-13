package com.example.ReactApi.service;

import com.example.ReactApi.model.Counter;
import com.example.ReactApi.repository.CounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CounterService {

    private final CounterRepository counterRepository;

    public Counter decrementCounter(Integer counterId) {
        counterRepository.decrementCounter(counterId);
        return getCounterById(counterId);
    }

    public Counter incrementCounter(Integer counterId) {
        counterRepository.incrementCounter(counterId);
        return getCounterById(counterId);
    }

    public Counter getCounterById(Integer counterId) {
        return counterRepository.findById(counterId).orElse(new Counter(-1, 0));
    }

    public Counter saveCounter() {
        return counterRepository.save(Counter.builder()
                .value(0)
                .build()
        );
    }

}
