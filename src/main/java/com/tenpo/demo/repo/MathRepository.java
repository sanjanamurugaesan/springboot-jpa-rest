package com.tenpo.demo.repo;

import com.tenpo.demo.entities.MathOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MathRepository extends JpaRepository<MathOperation, String> {
    List<MathOperation> findAll();
}
