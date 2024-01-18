package com.cedula.ups;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CedulaRepository extends JpaRepository<Cedula, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
