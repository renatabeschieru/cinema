package org.app.cinema.services.room;

import java.util.List;

import org.app.cinema.entities.Room;

public interface RoomService {

    void save(Room room);

    List<Room> getAll();
}
