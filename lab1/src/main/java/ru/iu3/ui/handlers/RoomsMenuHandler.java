package ru.iu3.ui.handlers;

import java.util.Scanner;

import ru.iu3.enums.RoomEnum;
import ru.iu3.enums.RoomMenuEnum;
import ru.iu3.service.interfaces.RoomService;

public class RoomsMenuHandler {
    private static String ERROR_MSG = "Произошла ошибка: ";

    private Scanner scanner;
    private RoomService roomService;
    private DisplayHelper displayHelper;

    public RoomsMenuHandler(Scanner scanner, RoomService roomService, DisplayHelper displayHelper) {
        this.scanner = scanner;
        this.roomService = roomService;
        this.displayHelper = displayHelper;
    }

    // Пул констант (coool!) Перенести все строковые константы (выводы) в interface!
    public void run() {
        boolean inRoomsMenu = true;
        while (inRoomsMenu) {
            for (RoomMenuEnum item : RoomMenuEnum.values()) {
                System.out.println(item.getId() + ". " + item.getDisplayName());
            }
            try {
                System.out.print("Выберите пункт меню: ");
                int choice = Integer.parseInt(scanner.nextLine());
                RoomMenuEnum selected = RoomMenuEnum.findByKey(choice);

                switch (selected) {
                    case SHOW_ALL:
                        displayHelper.showRooms();
                        break;
                    case ADD:
                        addRoom();
                        break;
                    case LOCK:
                        displayHelper.showRooms();
                        lockRoom();
                        break;
                    case EXIT:
                        inRoomsMenu = false;
                        break;
                    default:
                        System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                }

            } catch (Exception e) {
                System.out.println(ERROR_MSG + e.getMessage());
            }
        }
    }

    public void lockRoom() {
        
        System.out.println("Введите ID комнаты для запечатывания:");
        int id = Integer.parseInt(scanner.nextLine());
        roomService.lockRoom(id);
    }

    public void addRoom() {
        System.out.println("Введите тип комнаты:");
        for (RoomEnum type : RoomEnum.values()) {
            System.out.println(type.getId() + ". " + type.getDisplayName());
        }
        int typeId = Integer.parseInt(scanner.nextLine());
        RoomEnum type = RoomEnum.findByKey(typeId);
        System.out.println("Введите ID комнаты:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите название комнаты:");
        String name = scanner.nextLine();
        System.out.println("Введите ставку аренды (руб/час):");
        int hourlyRate = Integer.parseInt(scanner.nextLine());
        roomService.addRoom(type, id, name, hourlyRate);
    }
}
