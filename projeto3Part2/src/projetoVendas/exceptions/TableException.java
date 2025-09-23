package projetoVendas.exceptions;


import java.io.Serial;

public class TableException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public TableException(String msg) {
        super(msg);
    }
}
