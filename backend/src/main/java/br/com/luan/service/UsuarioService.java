package br.com.luan.service;

import br.com.luan.CriarUsuarioDTO;
import br.com.luan.commons.MultipartForm;
import br.com.luan.commons.pagination.PaginacaoDados;
import br.com.luan.commons.pagination.Paginavel;
import br.com.luan.model.FotoRostoUsuario;
import br.com.luan.model.Usuario;
import br.com.luan.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UsuarioService extends BaseService<Usuario, UsuarioRepository> {

    @Inject
    FotoRostoUsuarioService fotoRostoUsuarioService;

    public PaginacaoDados<Usuario> buscarTodos(Paginavel paginavel) {
        return this.buscarTodosPaginados(paginavel);
    }

    public Usuario criar(CriarUsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioDTO.dataTransferObjectToEntity();
        MultipartForm multipartForm = usuarioDTO.multipartForm();
        FotoRostoUsuario fotoRostoUsuario = fotoRostoUsuarioService.construirInstancia(multipartForm);
        String caminho = fotoRostoUsuarioService.salvar(usuario, fotoRostoUsuario);
        return super.criar(usuario);
    }
}
