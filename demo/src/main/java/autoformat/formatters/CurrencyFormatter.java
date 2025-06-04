package autoformat.formatters;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter implements Formatter<String> {
    
    @Override
    public String toDatabase(String value) {
        if (value == null) return null;
        // Remove R$, espaços e vírgulas, converte ponto para vírgula
        return value.replace("R$", "")
                   .replaceAll("\\s", "")
                   .replace(".", "")
                   .replace(",", ".");
    }

    @Override
    public String fromDatabase(String value) {
        if (value == null) return null;
        try {
            double amount = Double.parseDouble(value);
            NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            return formatter.format(amount); // Retorna no formato R$ 1.234,56
        } catch (NumberFormatException e) {
            return value;
        }
    }
} 