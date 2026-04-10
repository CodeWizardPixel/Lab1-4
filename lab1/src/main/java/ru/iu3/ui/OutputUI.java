package ru.iu3.ui;

import ru.iu3.enums.OptionsMenuEnum;

public class OutputUI {

    public void showWelcome() {
        System.out.println("--- Добро пожаловать в чудный консольный коворкинг! ---");
    }

    public void showOptions() {
        for (OptionsMenuEnum option : OptionsMenuEnum.values()) {
            System.out.println(option.getKey() + ". " + option.getLabel());
        }
    }

    public void showPrompt() {
        System.out.print("Выберите пункт меню: ");
    }

    public void showChoice(String choice) {
        System.out.println("Вы выбрали '" + choice + "'");
    }

    public void showInvalidChoice() {
        System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
    }

    public void showGoodbye() {
        System.out.println("Споки-ноки :3c ~");
    }

    public void showError(String message) {
        System.out.println("Произошла ошибка: " + message);
    }
}
