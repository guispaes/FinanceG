package br.com.fiap.financeg.model;

public class Login extends Usuario {

    private String login;
    private String senha;

    // Construtor com Super
    public Login() {
        super();
    }

    // Construtor com a Superclasse
    public Login(String nome, String login, String senha) {
        super(nome);
        this.login = login;
        this.senha = senha;
    }

    // Getters
    public String getLogin() { return login; }
    public String getSenha() { return senha; }

    // Setters
    public void setLogin(String login) { this.login = login; }
    public void setSenha(String senha) { this.senha = senha; }

    // Metodo para validar se o Login é válido
    public boolean autenticar(String loginInformado, String senhaInformada) {
        return this.login.equals(loginInformado) && this.senha.equals(senhaInformada);
    }
}