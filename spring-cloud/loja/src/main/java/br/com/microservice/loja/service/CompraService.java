package br.com.microservice.loja.service;

import br.com.microservice.loja.client.FornecedorClient;
import br.com.microservice.loja.controller.dto.CompraDto;
import br.com.microservice.loja.controller.dto.InfoFornecedorDto;
import br.com.microservice.loja.controller.dto.InfoPedidoDto;
import br.com.microservice.loja.model.Compra;
import br.com.microservice.loja.repository.CompraRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompraService {

    private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);


    @Autowired
    private FornecedorClient fornecedorClient;

    @Autowired
    private CompraRepository compraRepository;

    @HystrixCommand( threadPoolKey = "getByIdThreadPool")
    public Compra getCompra(Long id) {
        return compraRepository.findById(id).orElse(new Compra());
    }

    @HystrixCommand(fallbackMethod = "realizaCompraFallback", threadPoolKey = "realizaCompraThreadPool")
    public Compra realizaCompra(CompraDto compraDto) {
        final String estado = compraDto.getEndereco().getEstado();

        LOG.info("biscando informações do fornecedor de {}", estado);

        InfoFornecedorDto info = fornecedorClient.getInfoPorEstado(estado);

        LOG.info("realizando um pedido");

        InfoPedidoDto pedido = fornecedorClient.realizaPedido(compraDto.getItens());
        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
        compraSalva.setEnderecoDestino(compraDto.getEndereco().toString());

        compraRepository.save(compraSalva);

        return compraSalva;
    }

    public Compra realizaCompraFallback(CompraDto compra){
        Compra compraFallback = new Compra();

        compraFallback.setEnderecoDestino(compra.getEndereco().toString());
        return compraFallback;
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
