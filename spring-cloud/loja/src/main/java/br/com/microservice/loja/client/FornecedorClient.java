package br.com.microservice.loja.client;

import br.com.microservice.loja.controller.dto.InfoFornecedorDto;
import br.com.microservice.loja.controller.dto.InfoPedidoDto;
import br.com.microservice.loja.controller.dto.ItemDaCompraDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFornecedorDto getInfoPorEstado(@PathVariable String estado);

    @RequestMapping(method = RequestMethod.POST,value = "/pedido")
    InfoPedidoDto realizaPedido(List<ItemDaCompraDto> itens);

}
