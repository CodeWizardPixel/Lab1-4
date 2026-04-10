package ru.iu3.repository.interfaces;

import java.util.List;

import ru.iu3.entity.Pass;

public interface PassRepository { // Седелать Generic
    void add(Pass pass);

    Pass getById(int id);

    List<Pass> getAll();

    void update(Pass pass);
}
