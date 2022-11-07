package br.com.microservice.fornecedor.repository;

import br.com.microservice.fornecedor.model.Pedido;
import org.springframework.data.repository.CrudRepository;


public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
