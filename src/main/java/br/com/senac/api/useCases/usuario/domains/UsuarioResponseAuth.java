package br.com.senac.api.useCases.usuario.domains;

import org.springframework.beans.factory.annotation.Value;

public class UsuarioResponseAuth {

    private String login;
    private String token;
    @Value("${spring.security.expiration_time}")
    private Long expirarionTime;

    public UsuarioResponseAuth(String login, String token) {
        this.login = login;
        this.token = token;
    }

    public UsuarioResponseAuth(String login, String token, Long expirarionTime) {
        this.login = login;
        this.token = token;
        this.expirarionTime = expirarionTime;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public Long getExpirarionTime() {
        return expirarionTime;
    }

    public void setExpirarionTime(Long expirarionTime) {
        this.expirarionTime = expirarionTime;
    }

}
