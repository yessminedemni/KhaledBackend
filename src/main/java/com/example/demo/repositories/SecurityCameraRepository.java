package com.example.demo.repositories;

import com.example.demo.entities.SecurityCamera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityCameraRepository extends JpaRepository<SecurityCamera, Long> {
}
