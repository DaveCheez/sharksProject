package com.fusionarc.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fusionarc.demo.entity.Shark;

@Repository
public interface SharkRepo extends JpaRepository<Shark, Long> {

}
