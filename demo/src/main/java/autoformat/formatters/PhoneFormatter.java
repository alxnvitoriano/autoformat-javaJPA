package autoformat.formatters;

public class PhoneFormatter implements Formatter<String> {
    @Override
    public String toDatabase(String value) {
        if (value == null) return null;
        return value.replaceAll("[^0-9]", ""); // remove tudo exceto números
    }

    @Override
    public String fromDatabase(String value) {
        if (value == null || value.length() != 11) return value;
        return String.format("(%s) %s-%s",
            value.substring(0, 2),
            value.substring(2, 7),
            value.substring(7)); // formato (11) 98765-4321
    }
} 