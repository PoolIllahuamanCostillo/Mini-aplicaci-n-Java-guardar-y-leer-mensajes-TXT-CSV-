package es.fplumara.dam1.config;

import es.fplumara.dam1.exceptions.ConfigException;
import es.fplumara.dam1.files.StoreType;
import java.io.*;
import java.nio.file.*;
import java.util.Properties;

public class AppConfig {

    // Atributos (variables que guardan la configuración)
    private StoreType storeType;    // TXT o CSV
    private String messagesFile;    // ruta del archivo de mensajes
    private int messagesmaxLength;          // Longitud máxima de mensajes

    public AppConfig () throws ConfigException {

        // Se crea un objeto Path que apunta al archivo de configuración.
        Path path = Path.of("data/config.properties");
        Properties props = new Properties();

        // Abre un InputStream para leer bytes del archivo.
        // newInputStream(): abre el fichero tal cual está en el disco.
        // El try (...) es un try-with-resources → asegura que el archivo se cierra automáticamente.
        try (InputStream in = Files.newInputStream(path)) {
            props.load(in);
        } catch (IOException e) {
            throw new ConfigException("No se puede leer config.properties");
        }

        // Validar las claves que "existen" -----> uso del null:
        // Aquí el fichero .properties solo devuelve texto(String):

        // storeType
        String type = props.getProperty("store.type");
        if (type == null){
            throw new ConfigException("Falta store.type");
        }

        try {
           this.storeType = StoreType.valueOf(type); // aquí se convertirá el string del config a un enum

        } catch (IllegalArgumentException e) { // Se lanza la excepción
            throw new ConfigException("store.type debe ser FILE o CSV");
        }

        // messagesFile
        this.messagesFile = props.getProperty("messages.file");
        if (messagesFile == null){
            throw new ConfigException("Falta messagesFile");
        }

        // messagesmaxLength
        String max = props.getProperty("messages.maxLength");
        if (max == null){
            throw new ConfigException("Falta messages.maxLength");
        }

        try {
            this.messagesmaxLength = Integer.parseInt(max); // aquí se convertirá el string en un int

        } catch (NumberFormatException e) { // Se lanza la excepción
            throw new ConfigException("messages.maxLength debe ser un número");
        }

    }

    // Getters
    public StoreType getStoreType() {
        return storeType;
    }

    public String getMessagesFile() {
        return messagesFile;
    }

    public int getMessagesmaxLength() {
        return messagesmaxLength;
    }

}
