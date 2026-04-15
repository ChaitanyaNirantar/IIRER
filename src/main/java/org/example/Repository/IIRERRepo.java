package org.example.Repository;

import org.apache.catalina.User;
import org.example.Entity.IIRER_Entity;
import org.example.Entity.SignupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IIRERRepo  extends JpaRepository<IIRER_Entity, Long> {
    List<IIRER_Entity> findByEmailContainingIgnoreCase(String email);
}
