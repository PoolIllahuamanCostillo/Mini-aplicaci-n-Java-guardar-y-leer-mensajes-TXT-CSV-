package es.fplumara.dam1.exceptions;

public class StoreException extends RuntimeException {
    public StoreException(String message) {
        super(message);
    }
}

/*
    Representa **errores al guardar o leer mensajes**.
    Se usa cuando:
    - no se puede crear el fichero
    - no se puede escribir
    - no se puede leer
    - el CSV está mal formado

*/