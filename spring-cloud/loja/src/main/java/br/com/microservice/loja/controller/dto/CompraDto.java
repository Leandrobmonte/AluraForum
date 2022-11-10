package br.com.microservice.loja.controller.dto;

import br.com.microservice.loja.controller.enums.CompraState;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class CompraDto {

    @JsonIgnore
    private Long compraId;

    private List<ItemDaCompraDto> itens;
    private EnderecoDto endereco;

    public Long getCompraId() {
        return compraId;
    }

    public void setCompraId(Long compraId) {
        this.compraId = compraId;
    }

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
