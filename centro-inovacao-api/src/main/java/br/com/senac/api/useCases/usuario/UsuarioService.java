package br.com.senac.api.useCases.usuario;

import br.com.senac.api.entitys.Usuario;
import br.com.senac.api.jwt.TokenService;
import br.com.senac.api.useCases.usuario.domains.UsuarioLoginRequest;
import br.com.senac.api.useCases.usuario.domains.UsuarioResponseAuth;
import br.com.senac.api.useCases.usuario.implement.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UsuarioResponseAuth loginUsuario(UsuarioLoginRequest usuarioLoginRequest) throws Exception {

        Optional<Usuario> usuarioResult =
                usuarioRepository.findByLogin(usuarioLoginRequest.getLogin());

        if (!usuarioResult.isPresent()){
            throw new Exception("Usuário não encontrado!");
        }

        Usuario usuario = usuarioResult.get();

        if (passwordEncoder.matches(
                usuarioLoginRequest.getSenha(),
                usuario.getSenha())){
            String token = tokenService.gerarToken(usuario);

            return new UsuarioResponseAuth(
                    usuario.getLogin(),
                    token
            );

        }

        throw new Exception("Senha inválida!");

    }


    public String cadastrarUsuario(UsuarioLoginRequest usuario) throws Exception{

        Optional<Usuario> resultLogin
                = usuarioRepository.findByLogin(usuario.getLogin());

        if(resultLogin.isPresent()){
            throw new Exception("Usuário já está cadastrado na base de dados!");
        }

        Usuario usuarioPersist = new Usuario();

        usuarioPersist.setSenha(passwordEncoder.encode(usuario.getSenha()));

        Usuario usuarioPersistResult = usuarioRepository.save(usuarioPersist);

        return "Usuário cadastrado com sucesso!";

    }


}
