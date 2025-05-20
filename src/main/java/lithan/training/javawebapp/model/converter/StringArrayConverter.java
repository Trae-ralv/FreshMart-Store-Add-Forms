package lithan.training.javawebapp.model.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

// Converter to handle String[] to comma-separated string for JPA
@Converter
public class StringArrayConverter implements AttributeConverter<String[], String> {
    // Convert String[] to comma-separated string for database storage
    @Override
    public String convertToDatabaseColumn(String[] attribute) {
        return attribute != null ? String.join(",", attribute) : "";
    }

    // Convert comma-separated string to String[] for entity
    @Override
    public String[] convertToEntityAttribute(String dbData) {
        return dbData != null && !dbData.isEmpty() ? dbData.split(",") : new String[0];
    }
}