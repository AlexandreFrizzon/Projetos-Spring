package school.sptech.prova_ac1;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> buscarPorDataNascimentoMaiorQue(LocalDate nascimento) {
        return usuarioRepository.findByDataNascimentoGreaterThan(nascimento);
    }}