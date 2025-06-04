package autoformat.formatters;

public class CpfFormatter implements Formatter<String> {
    
    @Override 
    public String toDatabase(String value) {
        if (value == null) return null;
        return value.replaceAll("[^0-9]", ""); //remove the masks
    }

    @Override
    public String fromDatabase(String value) {
        if (value == null || value.length() != 11) return value;
        return value.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4"); //add the masks
    }
}