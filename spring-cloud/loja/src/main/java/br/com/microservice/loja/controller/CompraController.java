package br.com.microservice.loja.controller;

import br.com.microservice.loja.controller.dto.CompraDto;
import br.com.microservice.loja.model.Compra;
import br.com.microservice.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;


    @GetMapping("/{id}")
    public Compra getCompra(@PathVariable("id") Long id){
        return compraService.getCompra(id);
    }


    @PostMapping
    public Compra realizaCompra(@RequestBody CompraDto compraDto){
        return compraService.realizaCompra(compraDto);
    }
}
