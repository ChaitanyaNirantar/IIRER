package org.example.Repository;

import org.example.Entity.CIEEntity;
import org.example.Entity.DRSEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DRSRepo extends JpaRepository<DRSEntity, Long> {

}
