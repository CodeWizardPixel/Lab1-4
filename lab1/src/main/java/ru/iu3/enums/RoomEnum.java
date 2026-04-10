package ru.iu3.enums;

public enum RoomEnum {
    MEETING_ROOM("Переговорная"),
    WORKPLACE("Рабочее место");

    private String displayName;

    RoomEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
