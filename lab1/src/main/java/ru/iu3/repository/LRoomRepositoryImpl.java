package ru.iu3.repository;

import java.util.ArrayList;
import java.util.List;

import ru.iu3.entity.interfaces.Room;
import ru.iu3.repository.interfaces.RoomRepository;

public class LRoomRepositoryImpl implements RoomRepository {
    private List<Room> rooms = new ArrayList<Room>();

    @Override
    public void add(Room room) {
        rooms.add(room);
    }

    @Override
    public Room getById(int id) {
        for (Room room : rooms) {
            if (room.getId() == id) {
                return room;
            }
        }
        return null;
    }

    @Override
    public List<Room> getAll() {
        return rooms;
    }

    @Override
    public void deleteRoom(int id) {
        Room roomToDelete = getById(id);
        if (roomToDelete != null) {
            rooms.remove(roomToDelete);
        }
    }
}
