package br.com.microservice.loja.client;

import br.com.microservice.loja.controller.dto.InfoFornecedorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFornecedorDto getInfoPorEstado(@PathVariable String estado);

}
