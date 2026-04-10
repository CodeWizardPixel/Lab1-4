package ru.iu3.repository.interfaces;

import java.util.List;

import ru.iu3.entity.Booking;

public interface BookingRepository {
    void add(Booking booking);

    Booking getById(int id);
    
    List<Booking> getAll();

    void update(Booking booking);
}
