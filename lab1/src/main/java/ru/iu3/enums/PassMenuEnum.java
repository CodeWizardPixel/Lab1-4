package ru.iu3.enums;

public enum PassMenuEnum {
    SHOW_ALL(1, "Список пропусков"),
    ISSUE(2, "Добавить пропуск"),
    DEACTIVATE(3, "Удалить пропуск"),
    SHOW_ACCESS(4, "Показать доступ к комнатам"),
    EXIT(0, "Назад");

    private int id;
    private String displayName;

    PassMenuEnum(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static PassMenuEnum findByKey(int key) {
        for (PassMenuEnum item : PassMenuEnum.values()) {
            if (item.id == key) {
                return item;
            }
        }
        return null;
    }
}
