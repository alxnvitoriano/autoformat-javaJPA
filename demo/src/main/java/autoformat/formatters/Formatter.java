package autoformat.formatters;

public interface Formatter<T>{
    T toDatabase(T value);
    T fromDatabase(T value);
}