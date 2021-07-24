package com.example.demo.repository;

import com.example.demo.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubsRepository extends JpaRepository<Subscription,Long> {
    List<Subscription> findByStudentId(Long id);
    void deleteByTutorId (Long id);
    Subscription findByTutorIdAndStudentId(Long idt ,Long ids);
}
