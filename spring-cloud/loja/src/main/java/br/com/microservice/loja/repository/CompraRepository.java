package br.com.microservice.loja.repository;

import br.com.microservice.loja.model.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends CrudRepository<Compra,Long> {

}
