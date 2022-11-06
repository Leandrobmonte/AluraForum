package br.com.microservice.loja.service;

import br.com.microservice.loja.controller.dto.CompraDto;
import br.com.microservice.loja.controller.dto.InfoFornecedorDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {


    public void realizaCompra(CompraDto compraDto) {
        RestTemplate client = new RestTemplate();
        ResponseEntity<InfoFornecedorDto> exchange =
                client.exchange("http://localhost:8081/info/"+ compraDto.getEndereco().getEstado()
             , HttpMethod.GET, null, InfoFornecedorDto.class);

        System.out.println(exchange.getBody().getEndereco());

    }
}
