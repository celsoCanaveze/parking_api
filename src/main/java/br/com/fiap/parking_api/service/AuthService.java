package br.com.fiap.parking_api.service;

import br.com.fiap.parking_api.dto.LoginDTO;
import br.com.fiap.parking_api.dto.UsuarioDTO;
import br.com.fiap.parking_api.model.Usuario;
import br.com.fiap.parking_api.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String login(LoginDTO loginDTO) {
        Optional<Usuario> userOpt = usuarioRepository.findByUsername(loginDTO.getUsername());

        if (userOpt.isPresent()) {
            Usuario user = userOpt.get();
            if (user.getPassword().equals(loginDTO.getPassword())) {
                // Aqui você pode gerar um token JWT real, mas vou retornar um placeholder
                return "token-de-exemplo";
            }
        }
        throw new RuntimeException("Usuário ou senha inválidos");
    }

    public UsuarioDTO register(UsuarioDTO usuarioDTO) {
        // Converter DTO para entidade
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        // Salvar no banco
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        // Converter entidade de volta para DTO e retornar
        return modelMapper.map(usuarioSalvo, UsuarioDTO.class);
    }
}
