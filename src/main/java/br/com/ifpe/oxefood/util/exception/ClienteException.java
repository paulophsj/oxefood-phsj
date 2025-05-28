package br.com.ifpe.oxefood.util.exception;

public class ClienteException extends RuntimeException {

    public static final String DEVE_TER_DDD_81 = "O telefone deve ter o DDD 81";

    public ClienteException(String message) {
        super(String.format(message));
    }
}
