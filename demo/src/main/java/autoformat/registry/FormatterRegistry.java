package autoformat.registry;

import java.util.HashMap;
import java.util.Map;
import autoformat.formatters.Formatter;
import autoformat.formatters.CpfFormatter;
import autoformat.formatters.PhoneFormatter;
import autoformat.formatters.CurrencyFormatter;

public class FormatterRegistry {
    private static final Map<String, Formatter<?>> formatters = new HashMap<>();
    
    static {
        formatters.put("cpf", new CpfFormatter());
        formatters.put("phone", new PhoneFormatter());
        formatters.put("currency", new CurrencyFormatter());
    }

    @SuppressWarnings("unchecked")
    public static <T> Formatter<T> getFormatter(String type) {
        return (Formatter<T>) formatters.get(type);
    }
}