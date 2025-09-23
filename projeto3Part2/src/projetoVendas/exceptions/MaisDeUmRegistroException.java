package projetoVendas.exceptions;

import java.io.Serial;

public class MaisDeUmRegistroException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public MaisDeUmRegistroException(String msg) {
        super(msg);
    }
}
