package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import danidevs.contabancaria.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
