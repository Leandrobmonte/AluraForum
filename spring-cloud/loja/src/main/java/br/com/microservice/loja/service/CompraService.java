package br.com.microservice.loja.service;

import br.com.microservice.loja.client.FornecedorClient;
import br.com.microservice.loja.controller.dto.CompraDto;
import br.com.microservice.loja.controller.dto.InfoFornecedorDto;
import br.com.microservice.loja.controller.dto.InfoPedidoDto;
import br.com.microservice.loja.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDto compraDto) {

        InfoFornecedorDto info = fornecedorClient.getInfoPorEstado(compraDto.getEndereco().getEstado());

        InfoPedidoDto pedido = fornecedorClient.realizaPedido(compraDto.getItens());
        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
        compraSalva.setEnderecoDestino(compraDto.getEndereco().toString());
        return compraSalva;
    }



    // Exemplo de como funciona com Load Balance do Ribbo com RestTemplate

//    @Autowired
//    private RestTemplate client;

//    @Autowired
//    private DiscoveryClient eurekaClient;

//    public void realizaCompra(CompraDto compraDto) {
//        ResponseEntity<InfoFornecedorDto> exchange =
//                client.exchange("http://fornecedor/info/"+ compraDto.getEndereco().getEstado()
//             , HttpMethod.GET, null, InfoFornecedorDto.class);
//
//        eurekaClient.getInstances("fornecedor").stream()
//                        .forEach(fornecedor -> {
//                            System.out.println("localhost:" +fornecedor.getPort());
//                        });
//
//        System.out.println(exchange.getBody().getEndereco());
//
//    }

}
