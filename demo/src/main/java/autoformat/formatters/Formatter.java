package autoformat.formatters;

public interface Formatter<T>{
    T toDatabase(T value);// Prepara o valor para salvar no banco
    T fromDatabase(T value);// Formata o valor para exibição
}
