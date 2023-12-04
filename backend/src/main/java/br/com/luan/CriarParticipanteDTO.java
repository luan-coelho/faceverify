package br.com.luan;

import br.com.luan.commons.MultipartForm;
import br.com.luan.model.Participante;
import br.com.luan.model.Usuario;

public record CriarParticipanteDTO(
        String nome,
        String sobreNome,
        String email,
        String cpf,
        String senha,
        MultipartForm multipartForm) {

    public Participante dataTransferObjectToEntity(){
        Usuario usuario = new Usuario();
        usuario.setNome(this.nome());
        usuario.setSobreNome(this.sobreNome());
        usuario.setCpf(this.cpf());
        usuario.setEmail(this.email());
        usuario.setSenha(this.senha());
        Participante participante = new Participante();
        participante.setUsuario(usuario);
        return participante;
    }
}
