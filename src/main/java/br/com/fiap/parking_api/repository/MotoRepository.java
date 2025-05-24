package br.com.fiap.parking_api.repository;

import br.com.fiap.parking_api.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {

}