package br.com.luan.commons;

import jakarta.ws.rs.FormParam;

import java.io.InputStream;

public class MultipartForm {

    @FormParam("file")
    public InputStream inputStream;

    @FormParam("fileName")
    public String fileName;
}
