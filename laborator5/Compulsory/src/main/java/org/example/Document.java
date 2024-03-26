package org.example;

/**
 * Clasa Document
 * @param name
 * @param format
 */
public record Document(String name, String format) {
    /**
     * Constructorul lui Document care arunca exceptii daca name sau format sunt nule sau goale
     * @param name
     * @param format
     */
    public Document {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must be non-null");
        }
        if (format == null || format.isBlank()) {
            throw new IllegalArgumentException("format must be non-null");
        }
    }

    /**
     *  Metoda toString pentru a afisa  informatii despre un document (nume si format)
     * @return
     */
    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
