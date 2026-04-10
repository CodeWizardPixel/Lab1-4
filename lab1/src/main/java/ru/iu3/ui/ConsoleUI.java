package ru.iu3.ui;

import java.util.Scanner;

import ru.iu3.service.interfaces.BookingService;
import ru.iu3.service.interfaces.PassService;
import ru.iu3.service.interfaces.RoomService;
import ru.iu3.ui.handlers.BookingsMenuHandler;
import ru.iu3.ui.handlers.DisplayHelper;
import ru.iu3.ui.handlers.PassesMenuHandler;
import ru.iu3.ui.handlers.RoomsMenuHandler;
import ru.iu3.util.TestDataUtils;

public class ConsoleUI {
    private MainMenu mainMenuRunner;

    public ConsoleUI(Scanner scanner, RoomService roomService, PassService passService, BookingService bookingService, DisplayHelper displayHelper) {
        OutputUI display = new OutputUI();

        TestDataUtils testDataUtils = new TestDataUtils(roomService, passService, bookingService);
        RoomsMenuHandler roomsMenuHandler = new RoomsMenuHandler(scanner, roomService, displayHelper);
        PassesMenuHandler passesMenuHandler = new PassesMenuHandler(scanner, passService, bookingService, displayHelper);
        BookingsMenuHandler bookingsMenuHandler = new BookingsMenuHandler(scanner, bookingService,
                roomsMenuHandler, passesMenuHandler, displayHelper);

        this.mainMenuRunner = new MainMenu(scanner, display, roomsMenuHandler, passesMenuHandler, bookingsMenuHandler, testDataUtils);
    }

    public void start() {
        mainMenuRunner.run();
    }
}
