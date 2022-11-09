package br.com.microservice.loja.client;

import br.com.microservice.loja.controller.dto.InfoEntregaDto;
import br.com.microservice.loja.controller.dto.VoucherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("transportador")
public interface TransportadorClient {

    @RequestMapping(method = RequestMethod.POST, value = "/entrega")
    VoucherDto reservaEntrega(@RequestBody InfoEntregaDto pedidoDTO);
}
