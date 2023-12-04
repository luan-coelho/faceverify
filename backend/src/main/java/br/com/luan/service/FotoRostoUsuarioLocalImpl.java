package br.com.luan.service;

import br.com.luan.commons.MultipartForm;
import br.com.luan.model.FotoRostoUsuario;
import br.com.luan.model.FotoRostoUsuarioLocal;
import br.com.luan.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.BadRequestException;

import java.io.*;

@ApplicationScoped
public class FotoRostoUsuarioLocalImpl implements FotoRostoUsuarioService {

    public static final String DIRETORIO_USUARIO = System.getProperty("user.home");
    public static final String SEPARADOR = File.separator; // "\" ou "/"
    public static final String DIRETORIO_FOTOS = "rffotos";

    @Override
    public String salvar(Usuario usuario, FotoRostoUsuario fotoRostoUsuario) {
        return null;
    }

    @Override
    public FotoRostoUsuario construirInstancia(MultipartForm multipartForm) {
        FotoRostoUsuario fotoRostoUsuario = new FotoRostoUsuarioLocal();
//        fotoRostoUsuario.setArquivo(multipartForm);
        return null;
    }

    public String salvarArquivoEmDiscoRecuperandoCaminho(String identificador, InputStream inputStream) {
        String outputPath = SEPARADOR + DIRETORIO_FOTOS + SEPARADOR + identificador;
        String pathBuilt = DIRETORIO_USUARIO + outputPath;

        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(pathBuilt))) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathBuilt;
    }

    public File pegarArquivoFotoPeloCaminho(String identificador, InputStream inputStream) {
        String caminho = salvarArquivoEmDiscoRecuperandoCaminho(identificador, inputStream);
        String caminhoCompleto = DIRETORIO_USUARIO + caminho;
        try {
            return new File(caminhoCompleto);
        } catch (Exception e) {
            throw new BadRequestException("Recurso não encontrado. Caminho inválido ou arquivo ausente");
        }
    }
}
