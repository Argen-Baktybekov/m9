package edu.attractor.kg.m9.entities;

public enum Category {
    FLOWERS("flowers"),
    BALLOONS("balloons"),
    STUFFED_TOYS("stuffed toys"),
    FIREWORKS("fireworks"),
    OTHER("other");

    private String value;

    Category(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
