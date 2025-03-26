package school.sptech.prova_ac1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?> adicionarUsuario(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistenteEmail = usuarioRepository.findByEmail(usuario.getEmail());
        Optional<Usuario> usuarioExistenteCpf = usuarioRepository.findByCpf(usuario.getCpf());

        if (usuarioExistenteEmail.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro: O e-mail já está cadastrado.");
        }

        if (usuarioExistenteCpf.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro: O CPF já está cadastrado.");
        }

        Usuario novoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
        public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
            return usuarioRepository.findById(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Usuário não encontrado.");
        }

        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtro-data")
    public ResponseEntity<List<Usuario>> buscarPorDataNascimentoMaiorQue(@RequestParam String nascimento) {
        LocalDate dataNascimento = LocalDate.parse(nascimento);
        List<Usuario> usuarios = usuarioService.buscarPorDataNascimentoMaiorQue(dataNascimento);

        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario novoUsuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: Usuário não encontrado.");
        }

        Usuario usuario = usuarioExistente.get();

       if (!usuario.getEmail().equals(novoUsuario.getEmail())) {
            Optional<Usuario> usuarioComMesmoEmail = usuarioRepository.findByEmail(novoUsuario.getEmail());
            if (usuarioComMesmoEmail.isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Erro: O e-mail já está em uso por outro usuário.");
            }
        }

        if (!usuario.getCpf().equals(novoUsuario.getCpf())) {
            Optional<Usuario> usuarioComMesmoCpf = usuarioRepository.findByCpf(novoUsuario.getCpf());
            if (usuarioComMesmoCpf.isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Erro: O CPF já está em uso por outro usuário.");
            }
        }

        usuario.setNome(novoUsuario.getNome());
        usuario.setEmail(novoUsuario.getEmail());
        usuario.setCpf(novoUsuario.getCpf());
        usuario.setSenha(novoUsuario.getSenha());
        usuario.setDataNascimento(novoUsuario.getDataNascimento());

        Usuario usuarioAtualizado = usuarioRepository.save(usuario);

        return ResponseEntity.ok(usuarioAtualizado);
    }

}
