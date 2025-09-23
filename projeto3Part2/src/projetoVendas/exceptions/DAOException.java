package projetoVendas.exceptions;

import java.io.Serial;

public class DAOException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public DAOException(String msg, Exception ex) {
        super(msg, ex);
    }
}
