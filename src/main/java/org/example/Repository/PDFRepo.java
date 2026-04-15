package org.example.Repository;

import org.example.Entity.PdfEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PDFRepo  extends JpaRepository<PdfEntity, Long> {
}
