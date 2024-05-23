package com.ejercicio.back.repositorios;

import com.ejercicio.back.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
