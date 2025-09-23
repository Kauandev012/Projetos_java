package projetoVendas.exceptions;

import java.io.Serial;

public class TipoElementoNaoConhecidoException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public TipoElementoNaoConhecidoException(String msg) {
        this(msg, null);
    }

    public TipoElementoNaoConhecidoException(String msg, Throwable e) {
        super(msg, e);
    }
}
