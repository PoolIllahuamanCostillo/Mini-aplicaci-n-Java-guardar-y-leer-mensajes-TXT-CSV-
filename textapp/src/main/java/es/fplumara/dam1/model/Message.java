package es.fplumara.dam1.model;

import java.time.Instant;

public class Message {

    //Atributos
    private String texto;

    // Se usa el tipo de dato "Isntant" que sirve para representar
    // un momento exacto en la línea de tiempo global en Java
    private Instant timestamp;
    private int wordCount;

    // Constructor:

    // El único dato que necesita el usuario para crear un mensaje es el texto
    public Message(String texto) {
        this.texto = texto;
        this.timestamp = Instant.now();
        this.wordCount = conteoWordCount(this.texto);   // <---- aquí se realiza el conteo
    }

    // Aquí se contará la cantidad de palabras del texto:
    private int conteoWordCount(String texto) {
        // Elimina espacios antes y después
        String textoSinEspacios = texto.trim();

        // Si la cadena del texto está vacío --> retorna 0 palabras |
        // Ejemplo: Si el usuario escribe: " " --> este if devolverá 0 palabras
        if (textoSinEspacios.isEmpty()){
            return 0;
        }

        // split(): Sirve para dividir una cadena de texto en varias partes
        // y su resultado es SIEMPRE un " String[] "
        String[] partes = textoSinEspacios.split("\\s+"); // Este divide por 1 o más espacios consecutivos

        // Cantidad de palabras
        return partes.length;

    }

    // Getters:
    public String getTexto() {
        return texto;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getWordCount() {
        return wordCount;
    }
}
