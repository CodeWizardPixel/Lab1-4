package ru.iu3.ui.handlers;

import java.util.List;

import ru.iu3.entity.Booking;
import ru.iu3.entity.Pass;
import ru.iu3.entity.interfaces.Room;
import ru.iu3.service.interfaces.BookingService;
import ru.iu3.service.interfaces.PassService;
import ru.iu3.service.interfaces.RoomService;

public class DisplayHelper {
    private PassService passService;
    private RoomService roomService;
    private BookingService bookingService;

    public DisplayHelper(PassService passService, RoomService roomService, BookingService bookingService) {
        this.passService = passService;
        this.roomService = roomService;
        this.bookingService = bookingService;
    }

    public void showRooms() {
        System.out.println("Cписок комнат:");
        List<Room> rooms = roomService.getAllRooms();
        if (rooms.isEmpty()) {
            System.out.println("Список комнат пуст.");
            return;
        }

        System.out.println("ID | Тип | Название | Ставка (руб/час)");
        for (Room room : rooms) {
            if (room.getIsLocked()) {
                System.out.println(room.getId() + " | " + room.getType().getDisplayName() + " | " + room.getName()
                        + " | " + room.getHourlyRate() + " (Запечатана)");
                continue;
            } else {
                System.out.println(room.getId() + " | " + room.getType().getDisplayName() + " | " + room.getName()
                        + " | " + room.getHourlyRate());
            }
        }
    }

    public void showPasses() {
        System.out.println("Cписок пропусков:");
        List<Pass> passes = passService.getAllPasses();
        if (passes.isEmpty()) {
            System.out.println("Список пропусков пуст.");
            return;
        }

        System.out.println("ID | Владелец | Активен");
        for (Pass pass : passes) {
            System.out.println(pass.getId() + " | " + pass.getHolderName() + " | " + pass.isActive());
        }
    }

    public void showBookings() {
        System.out.println("Список бронирований:");
        List<Booking> bookings = bookingService.getAllBookings();
        if (bookings.isEmpty()) {
            System.out.println("Список бронирований пуст.");
            return;
        }

        System.out.println("ID | ID Комнаты | Время начала | Время окончания | ID Пропуска");
        for (Booking booking : bookings) {
            System.out.println(booking.getId() + " | " + booking.getRoomId() + " | "
                    + booking.getStartTime() + " | " + booking.getEndTime() + " | " + booking.getPassId());
        }
    }
}
