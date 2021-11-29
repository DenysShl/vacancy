package ua.cv.vacancy.model;

/**
 * @autor shd on 24.11.2021
 * @created 24.11.2021 - 21:06
 * @project vacancy
 */

public enum Status {
    ACTIVE("user active"),
    BANNED("user banned");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
