package br.com.luan;

import br.com.luan.commons.MultipartForm;
import br.com.luan.model.Usuario;

public record CriarUsuarioDTO(
        String nome,
        String sobreNome,
        String email,
        String cpf,
        String senha,
        MultipartForm multipartForm) {

    public Usuario dataTransferObjectToEntity(){
        Usuario usuario = new Usuario();
        usuario.setNome(this.nome());
        usuario.setSobreNome(this.sobreNome());
        usuario.setCpf(this.cpf());
        usuario.setEmail(this.email());
        usuario.setSenha(this.senha());
        return usuario;
    }
}
