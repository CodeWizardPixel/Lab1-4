package ru.iu3.ui;

import java.util.Scanner;

import ru.iu3.enums.OptionsMenuEnum;
import ru.iu3.ui.handlers.BookingsMenuHandler;
import ru.iu3.ui.handlers.PassesMenuHandler;
import ru.iu3.ui.handlers.RoomsMenuHandler;
import ru.iu3.util.TestDataUtils;

public class MainMenu {
    private Scanner scanner;
    private OutputUI display;
    private RoomsMenuHandler roomsMenuHandler;
    private PassesMenuHandler passesMenuHandler;
    private BookingsMenuHandler bookingsMenuHandler;
    private TestDataUtils testDataUtils;

    public MainMenu(Scanner scanner, OutputUI display, RoomsMenuHandler roomsMenuHandler,
            PassesMenuHandler passesMenuHandler, BookingsMenuHandler bookingsMenuHandler, TestDataUtils testDataUtils) {
        this.scanner = scanner;
        this.display = display;
        this.roomsMenuHandler = roomsMenuHandler;
        this.passesMenuHandler = passesMenuHandler;
        this.bookingsMenuHandler = bookingsMenuHandler;
        this.testDataUtils = testDataUtils;
    }

    public void run() {
        boolean running = true;
        while (running) {
            display.showWelcome();
            display.showOptions();
            try {
                display.showPrompt();
                int choice = Integer.parseInt(scanner.nextLine());
                OptionsMenuEnum selected = OptionsMenuEnum.findByKey(choice);

                switch (selected) {
                    case ROOMS:
                        roomsMenuHandler.run();
                        break;
                    case PASSES:
                        passesMenuHandler.run();
                        break;
                    case BOOKINGS:
                        bookingsMenuHandler.run();
                        break;
                    case TEST:
                        testDataUtils.generateDemoData();
                        break;
                    case EXIT:
                        running = false;
                        display.showGoodbye();
                        break;
                    default:
                        display.showInvalidChoice();
                }

            } catch (Exception e) {
                display.showError(e.getMessage());
            }
        }
    }
}
