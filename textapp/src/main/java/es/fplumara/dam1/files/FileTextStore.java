package es.fplumara.dam1.files;

import es.fplumara.dam1.config.AppConfig;
import es.fplumara.dam1.model.Message;
import org.w3c.dom.ls.LSInput;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// Para qué sirve: Guarda mensajes en un fichero de texto, una línea por mensaje.
public class FileTextStore implements TextStore{

    // Definir atributos:
    private AppConfig appConfig;

    // Constructor:
    public FileTextStore(AppConfig appConfig) {
        this.appConfig = appConfig;
    }


    @Override
    public void save(Message message) {
        String ficheroSalida = appConfig.getMessagesFile();
        File file = new File(ficheroSalida);

        // Crear el fichero de salida si no existe
        if ()
    }

    @Override
    public String readAll() {

        Path path = Path.of(appConfig.getMessagesFile());
        try {
            String contenido = Files.readString(path);
            return contenido;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public String readLast(int n) {

        Path path = Path.of(appConfig.getMessagesFile());

        try {
            List<String> lineas = Files.readAllLines(path);
            int posicionInicial = Math.max(0, lineas.size()-numero);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "";
    }
}
