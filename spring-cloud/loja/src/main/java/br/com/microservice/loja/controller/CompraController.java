package br.com.microservice.loja.controller;

import br.com.microservice.loja.controller.dto.CompraDto;
import br.com.microservice.loja.service.CompraService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private CompraService compraService;
    @PostMapping
    public void realizaCompra(@RequestBody CompraDto compraDto){
        compraService.realizaCompra(compraDto);
    }
}
