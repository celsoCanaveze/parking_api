package br.com.fiap.parking_api.service;

import br.com.fiap.parking_api.dto.ClienteDTO;
import br.com.fiap.parking_api.model.Cliente;
import br.com.fiap.parking_api.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    public List<ClienteDTO> listar() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    public ClienteDTO cadastrar(ClienteDTO dto) {
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        cliente = clienteRepository.save(cliente);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    public ClienteDTO atualizar(Long id, ClienteDTO dto) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Atualiza os campos do cliente existente com os do DTO
        clienteExistente.setNome(dto.getNome());
        clienteExistente.setEmail(dto.getEmail());
        // atualize outros campos que tiver...

        clienteExistente = clienteRepository.save(clienteExistente);
        return modelMapper.map(clienteExistente, ClienteDTO.class);
    }

    public void remover(Long id) {
        clienteRepository.deleteById(id);
    }
}
