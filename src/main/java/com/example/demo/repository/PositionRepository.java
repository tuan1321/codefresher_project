package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position,Long> {

}
