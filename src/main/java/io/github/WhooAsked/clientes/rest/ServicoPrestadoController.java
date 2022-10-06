package io.github.WhooAsked.clientes.rest;


import io.github.WhooAsked.clientes.model.entity.Cliente;
import io.github.WhooAsked.clientes.model.entity.ServicoPrestado;
import io.github.WhooAsked.clientes.model.repository.ClienteRepository;
import io.github.WhooAsked.clientes.model.repository.ServicoPrestadoRepository;
import io.github.WhooAsked.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.WhooAsked.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository repository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto ){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente =
                clienteRepository
                        .findById(idCliente)
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.BAD_REQUEST, "Cliente inexistente"));


       ServicoPrestado servicoPrestado = new ServicoPrestado ();
       servicoPrestado.setDescricao(dto.getDescricao());
       servicoPrestado.setData( data );
       servicoPrestado.setCliente(cliente);
       servicoPrestado.setValor( bigDecimalConverter.converter(dto.getPreco()) );

       return repository.save(servicoPrestado);
    }

    @GetMapping
    public List<ServicoPrestado> pesquisar(
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ){
       return repository.findByNomeClienteAndMes("%" + nome + "%", mes);
    }
}
