package autoformat.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface Format {
    String type(); // escolhe o tipo de formatação ex: "cpf", "phone", "currency"
    String locale() default ""; // opcional, para formatar em um idioma específico, ex: "pt-BR"
}