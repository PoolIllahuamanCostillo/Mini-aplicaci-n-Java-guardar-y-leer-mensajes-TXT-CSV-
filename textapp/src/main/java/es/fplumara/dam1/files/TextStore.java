package es.fplumara.dam1.files;

import es.fplumara.dam1.model.Message;

public interface TextStore {

    // Recibe: un Message (clase creada en paso 6)
    // devuelve: nada
    // hace: guarda el mensaje
    public void save(Message message);

    // - recibe: nada
    // - devuelve: todo lo guardado como texto (String)
    public String readAll();

    // - recibe: un número N
    // - devuelve: las últimas N líneas o filas como texto (String)
    public String readLast(int n);
}
