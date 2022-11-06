package br.com.microservice.loja.controller.dto;

import java.util.List;

public class CompraDto {

    private List<ItemDaCompraDto> itens;
    private EnderecoDto endereco;

    public void setItens(List<ItemDaCompraDto> itens) {
        this.itens = itens;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    public List<ItemDaCompraDto> getItens() {
        return itens;
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }
}
