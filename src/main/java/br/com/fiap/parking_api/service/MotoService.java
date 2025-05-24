package br.com.fiap.parking_api.service;

import br.com.fiap.parking_api.dto.MotoDTO;
import br.com.fiap.parking_api.model.Moto;
import br.com.fiap.parking_api.repository.MotoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MotoService {

    private final MotoRepository motoRepository;
    private final ModelMapper modelMapper;

    public List<MotoDTO> listar() {
        return motoRepository.findAll().stream()
                .map(moto -> modelMapper.map(moto, MotoDTO.class))
                .collect(Collectors.toList());
    }

    public MotoDTO buscarPorId(Long id) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moto não encontrada"));
        return modelMapper.map(moto, MotoDTO.class);
    }

    public MotoDTO cadastrar(MotoDTO dto) {
        Moto moto = modelMapper.map(dto, Moto.class);
        moto = motoRepository.save(moto);
        return modelMapper.map(moto, MotoDTO.class);
    }

    public MotoDTO atualizar(Long id, MotoDTO dto) {
        Moto motoExistente = motoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moto não encontrada"));
        // Atualiza os campos do motoExistente com os dados do DTO
        motoExistente.setModelo(dto.getModelo());
        motoExistente.setPlaca(dto.getPlaca());
        // Atualize outros campos se houver

        motoExistente = motoRepository.save(motoExistente);
        return modelMapper.map(motoExistente, MotoDTO.class);
    }

    public void remover(Long id) {
        motoRepository.deleteById(id);
    }

    public MotoDTO registrarEntrada(Long id) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moto não encontrada"));

        // Para esse método funcionar, a classe Moto deve ter esse campo e setter:
        moto.setEntradaRegistrada(true);

        moto = motoRepository.save(moto);
        return modelMapper.map(moto, MotoDTO.class);
    }
}
