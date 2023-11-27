package com.example.pagina_status.repository;

import com.example.pagina_status.model.CotizacionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCotizacionStatus extends JpaRepository<CotizacionStatus, Integer> {
}
