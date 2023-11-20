package com.lp2.leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T, ID> extends JpaRepository<T, ID> {
    // Adicione métodos personalizados, se necessário
}
