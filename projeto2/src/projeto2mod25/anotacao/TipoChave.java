package projeto2mod25.anotacao;


import java.lang.annotation.*;



@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {

    String value();
}
