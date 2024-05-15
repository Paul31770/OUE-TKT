package com.example.server_basket.repository;

import com.example.server_basket.entity.matchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface matchRepository extends JpaRepository<matchEntity, Integer> {

}
