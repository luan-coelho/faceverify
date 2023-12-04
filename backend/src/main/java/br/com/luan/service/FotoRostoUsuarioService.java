package br.com.luan.service;

import br.com.luan.commons.MultipartForm;
import br.com.luan.model.FotoRostoUsuario;
import br.com.luan.model.Usuario;

public interface FotoRostoUsuarioService {

    /**
     * Responsável por salvar uma imagem em determinado storage
     *
     * @param usuario          Usuário dono da foto.
     * @param fotoRostoUsuario Contém informações sobre o arquivo de foto de rosto de um usuário.
     * @return caminho do arquivo
     */
    String salvar(Usuario usuario, FotoRostoUsuario fotoRostoUsuario);

    /**
     * Responsável por construir uma instância de foto de rosto de um usuário.
     *
     * @param multipartForm Contém dados necessários para construção de FotoRostoUsuario.
     * @return Instância de FotoRostoUsuario com todos os valores preenchidos.
     */
    FotoRostoUsuario construirInstancia(MultipartForm multipartForm);
}
