package ru.iu3.repository.interfaces;

import java.util.List;

import ru.iu3.entity.interfaces.Room;

public interface RoomRepository {
    void add(Room room);

    Room getById(int id);

    List<Room> getAll();

    void deleteRoom(int id);
}
