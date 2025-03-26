package com.boleto.apiBoleto.repository;

import com.boleto.apiBoleto.model.BoletoBancario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletoRepository extends JpaRepository<BoletoBancario, Long> {

    Long id(Long id);
}
