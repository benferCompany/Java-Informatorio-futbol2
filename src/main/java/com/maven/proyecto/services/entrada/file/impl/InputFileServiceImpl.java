package com.maven.proyecto.services.entrada.file.impl;

import com.maven.proyecto.services.entrada.file.InputFileService;
import java.util.ArrayList;
import java.util.List;

public class InputFileServiceImpl implements InputFileService {

    public List<String> inputFile(int i, List<String> contenido, String ch1, String ch2) {
        List<String> contenidoValor = new ArrayList<String>();
        String[] valoresComa = contenido.get(i).split(ch1);
        for (String valor : valoresComa) {

            String[] partes = valor.split(ch2);

            if (partes.length == 2) {
                //String clave = partes[0];
                String valorString = partes[1];

                contenidoValor.add(valorString);

            }
        }
        return contenidoValor;
    }
    

}
