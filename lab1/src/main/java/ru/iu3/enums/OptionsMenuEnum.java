package ru.iu3.enums;

public enum OptionsMenuEnum {
    ROOMS(1, "Комнаты"),
    PASSES(2, "Пропуска"),
    BOOKINGS(3, "Бронирования"),
    TEST(4, "Создать тестовые данные"),
    EXIT(0, "Выход");

    private final int key;
    private final String label;

    OptionsMenuEnum(int key, String label) {
        this.key = key;
        this.label = label;
    }

    public int getKey() {
        return key;
    }

    public String getLabel() {
        return label;
    }

    public static OptionsMenuEnum findByKey(int key) {
        for (OptionsMenuEnum option : OptionsMenuEnum.values()) {
            if (option.key == key) {
                return option;
            }
        }
        throw new IllegalArgumentException("Неверная опция меню: " + key);
    }
}
