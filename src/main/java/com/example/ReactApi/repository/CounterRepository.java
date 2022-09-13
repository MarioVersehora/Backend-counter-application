package com.example.ReactApi.repository;

import com.example.ReactApi.model.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CounterRepository extends JpaRepository<Counter, Integer> {

    @Transactional
    @Modifying(clearAutomatically=true)
    @Query("UPDATE my_counter t set t.value = t.value -1 WHERE t.id = :counterId")
    void decrementCounter(Integer counterId);

    @Transactional
    @Modifying(clearAutomatically=true)
    @Query("UPDATE my_counter t set t.value = t.value + 1 WHERE t.id = :counterId")
    void incrementCounter(Integer counterId);
}
