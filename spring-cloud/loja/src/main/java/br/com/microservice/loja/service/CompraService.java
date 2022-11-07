package br.com.microservice.loja.service;

import br.com.microservice.loja.controller.dto.CompraDto;
import br.com.microservice.loja.controller.dto.InfoFornecedorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private DiscoveryClient eurekaClient;
    @Autowired
    private RestTemplate client;

    public void realizaCompra(CompraDto compraDto) {
        ResponseEntity<InfoFornecedorDto> exchange =
                client.exchange("http://fornecedor/info/"+ compraDto.getEndereco().getEstado()
             , HttpMethod.GET, null, InfoFornecedorDto.class);

        eurekaClient.getInstances("fornecedor").stream()
                        .forEach(fornecedor -> {
                            System.out.println("localhost:" +fornecedor.getPort());
                        });

        System.out.println(exchange.getBody().getEndereco());

    }
}
