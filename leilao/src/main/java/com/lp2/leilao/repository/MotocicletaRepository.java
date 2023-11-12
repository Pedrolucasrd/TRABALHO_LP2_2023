package com.lp2.leilao.repository;

import com.lp2.leilao.model.Motocicleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotocicletaRepository extends JpaRepository<Motocicleta,Long> {
}
