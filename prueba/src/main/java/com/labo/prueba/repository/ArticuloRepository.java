package com.labo.prueba.repository;

import com.labo.prueba.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

    Optional<Articulo> findOptionalById(Long id);

}
