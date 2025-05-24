package br.com.fiap.parking_api.service;

import br.com.fiap.parking_api.dto.PatioDTO;
import br.com.fiap.parking_api.model.Patio;
import br.com.fiap.parking_api.repository.PatioRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatioService {

    private final PatioRepository patioRepository;
    private final ModelMapper modelMapper;

    public List<PatioDTO> listar() {
        return patioRepository.findAll().stream()
                .map(patio -> modelMapper.map(patio, PatioDTO.class))
                .collect(Collectors.toList());
    }

    public PatioDTO buscarPorId(Long id) {
        Patio patio = patioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pátio não encontrado"));
        return modelMapper.map(patio, PatioDTO.class);
    }

    public PatioDTO cadastrar(PatioDTO dto) {
        Patio patio = modelMapper.map(dto, Patio.class);
        patio = patioRepository.save(patio);
        return modelMapper.map(patio, PatioDTO.class);
    }

 public PatioDTO atualizar(Long id, PatioDTO dto) {
    Patio patioExistente = patioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pátio não encontrado"));

    patioExistente.setNome(dto.getNome());
    patioExistente.setEndereco(dto.getEndereco());

    patioExistente = patioRepository.save(patioExistente);
    return modelMapper.map(patioExistente, PatioDTO.class);
}   

    public void remover(Long id) {
        patioRepository.deleteById(id);
    }
}
