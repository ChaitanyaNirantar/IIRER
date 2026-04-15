package org.example.Repository;

import org.example.Entity.CIEEntity;
import org.example.Entity.IIRER_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CIERepo extends JpaRepository<CIEEntity, Long> {
}
