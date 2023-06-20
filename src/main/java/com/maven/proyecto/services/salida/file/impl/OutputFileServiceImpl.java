package com.maven.proyecto.services.salida.file.impl;

import com.maven.proyecto.services.salida.file.OutputFileService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class OutputFileServiceImpl implements OutputFileService {

    public String outputFile(List<String> listaJugadores, String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        try {
            
            FileUtils.writeLines(archivo, "UTF-8", listaJugadores);
            return "\n-------Datos exportados correctamente.--------";

        } catch (IOException e) {
            
            return e.getMessage();
        }
    }

}
