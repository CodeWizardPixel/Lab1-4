package ru.iu3.enums;

public enum BookingsMenuEnum {
    SHOW_ALL(1, "Список бронирований"),
    ADD(2, "Добавить бронирование"),
    CANCEL(3, "Удалить бронирование"),
    EXIT(0, "Назад");

    private final int id;
    private final String displayName;

    BookingsMenuEnum(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static BookingsMenuEnum findByKey(int key) {
        for (BookingsMenuEnum item : BookingsMenuEnum.values()) {
            if (item.id == key) {
                return item;
            }
        }
        return null;
    }
}
