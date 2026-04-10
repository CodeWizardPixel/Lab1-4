package ru.iu3.ui.handlers;

import java.util.List;
import java.util.Scanner;

import ru.iu3.entity.Pass;
import ru.iu3.entity.interfaces.Room;
import ru.iu3.enums.PassMenuEnum;
import ru.iu3.service.interfaces.BookingService;
import ru.iu3.service.interfaces.PassService;

public class PassesMenuHandler {
    private static String ERROR_MSG = "Произошла ошибка: ";

    private Scanner scanner;
    private PassService passService;
    private BookingService bookingService;
    private DisplayHelper displayHelper;

    public PassesMenuHandler(Scanner scanner, PassService passService, BookingService bookingService, DisplayHelper displayHelper) {
        this.scanner = scanner;
        this.passService = passService;
        this.bookingService = bookingService;
        this.displayHelper = displayHelper;
    }

    public void run() {
        boolean inPassesMenu = true;
        while (inPassesMenu) {
            for (PassMenuEnum item : PassMenuEnum.values()) {
                System.out.println(item.getId() + ". " + item.getDisplayName());
            }
            try {
                System.out.print("Выберите пункт меню: ");
                int choice = Integer.parseInt(scanner.nextLine());
                PassMenuEnum selected = PassMenuEnum.findByKey(choice);

                switch (selected) {
                    case SHOW_ALL:
                        displayHelper.showPasses();
                        break;
                    case ISSUE:
                        displayHelper.showPasses();
                        issuePass();
                        break;
                    case DEACTIVATE:
                        displayHelper.showPasses();
                        deactivatePass();
                        break;
                    case SHOW_ACCESS:
                        showAccess();
                        break;
                    case EXIT:
                        inPassesMenu = false;
                        break;
                    default:
                        System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                }

            } catch (Exception e) {
                System.out.println(ERROR_MSG + e.getMessage());
            }
        }
    }

    public void issuePass() {
        System.out.println("Введите ID пропуска:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите имя владельца пропуска:");
        String holderName = scanner.nextLine();
        passService.issuePass(id, holderName);
    }

    public void deactivatePass() {
        System.out.println("Введите ID пропуска для деактивации:");
        int id = Integer.parseInt(scanner.nextLine());
        passService.deactivatePass(id);
    }

    public void showAccess() {
        System.out.println("Введите ID пропуска для просмотра доступа:");
        int id = Integer.parseInt(scanner.nextLine());
        Pass pass = passService.getPassById(id);
        if (!pass.isActive()) {
            System.out.println("Пропуск неактивен. Доступ к комнатам отсутствует.");
            return;
        }

        List<Room> rooms = bookingService.getRoomsForPass(pass.getId());
        for (Room room : rooms) {
            System.out.println("Доступ к комнате: " + room.getName());
        }
    }

}
