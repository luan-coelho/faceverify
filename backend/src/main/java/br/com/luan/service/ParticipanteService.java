package br.com.luan.service;

import br.com.luan.CriarParticipanteDTO;
import br.com.luan.commons.MultipartForm;
import br.com.luan.commons.pagination.PaginacaoDados;
import br.com.luan.commons.pagination.Paginavel;
import br.com.luan.model.FotoRostoUsuario;
import br.com.luan.model.Participante;
import br.com.luan.model.Usuario;
import br.com.luan.repository.ParticipanteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ParticipanteService extends BaseService<Participante, ParticipanteRepository> {

    @Inject
    FotoRostoUsuarioService fotoRostoUsuarioService;

    public PaginacaoDados<Participante> buscarTodos(Paginavel paginavel) {
        return this.buscarTodosPaginados(paginavel);
    }

    public Participante criar(CriarParticipanteDTO participanteDTO) {
        Participante participante = participanteDTO.dataTransferObjectToEntity();
        MultipartForm multipartForm = participanteDTO.multipartForm();
        Usuario usuario = participante.getUsuario();
        FotoRostoUsuario fotoRostoUsuario = fotoRostoUsuarioService.construirInstancia(multipartForm);
        String caminho = fotoRostoUsuarioService.salvar(usuario, fotoRostoUsuario);
        return super.criar(participante);
    }
}
