package br.com.senac.api.controllers;

import br.com.senac.api.useCases.usuario.UsuarioService;
import br.com.senac.api.useCases.usuario.domains.UsuarioLoginRequest;
import br.com.senac.api.useCases.usuario.domains.UsuarioResponseAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody UsuarioLoginRequest usuarioLoginRequest){

        try {
            UsuarioResponseAuth usuarioResponseAuth =
                    usuarioService.loginUsuario(usuarioLoginRequest);

            return ResponseEntity.ok(usuarioResponseAuth);

        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioLoginRequest usuario){

        try {
            String response = usuarioService.cadastrarUsuario(usuario);
            return ResponseEntity.ok(response);

        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
