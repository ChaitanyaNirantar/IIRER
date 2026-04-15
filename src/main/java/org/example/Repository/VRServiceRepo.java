package org.example.Repository;

import org.example.Entity.IIRER_Entity;
import org.example.Entity.VR_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VRServiceRepo extends JpaRepository<VR_Entity, Long> {

}
