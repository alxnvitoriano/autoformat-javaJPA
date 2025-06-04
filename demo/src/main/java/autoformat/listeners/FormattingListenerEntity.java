package autoformat.listeners;

import jakarta.persistence.*;
import java.lang.reflect.Field;
import autoformat.annotation.Format;
import autoformat.formatters.Formatter;
import autoformat.registry.FormatterRegistry;


public class FormattingListenerEntity {
    @PrePersist
    @PreUpdate
    public void formatBeforeSave(Object entity) {
        System.out.println(">>> Antes de salvar: " + entity.getClass().getSimpleName());
        process(entity, true);
    }

    @PostLoad
    public void formatAfterLoad(Object entity){
        System.out.println(">>> Depois de carregar: " + entity.getClass().getSimpleName());
        process(entity, false);
    } 

    private void process(Object entity, boolean toDatabase) {
        for (Field field : entity.getClass().getDeclaredFields()){
            if (field.isAnnotationPresent(Format.class)) {
                Format annotation = field.getAnnotation(Format.class);
                Formatter<?> formatter = FormatterRegistry.getFormatter(annotation.type());
                if(formatter != null) {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(entity);
                        System.out.println(">>> Campo: " + field.getName() + ", Valor antes: " + value);
                        @SuppressWarnings("unchecked")
                        Object formatted = toDatabase
                                ? ((Formatter<Object>) formatter).toDatabase(value)
                                : ((Formatter<Object>) formatter).fromDatabase(value);
                        field.set(entity, formatted);
                        System.out.println(">>> Campo: " + field.getName() + ", Valor depois: " + formatted);
                    } catch (Exception e) {
                        System.out.println(">>> ERRO ao formatar campo: " + field.getName() + " - " + e.getMessage());
                        throw new RuntimeException("Erro ao formatar campo: " + field.getName(), e);
                    }
                } else {
                    System.out.println(">>> Formatter não encontrado para o tipo: " + annotation.type());
                }
            }
        }
    }
}