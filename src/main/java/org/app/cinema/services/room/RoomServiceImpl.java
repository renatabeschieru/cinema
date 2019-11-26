package org.app.cinema.services.room;

import java.util.List;

import org.app.cinema.entities.Room;
import org.app.cinema.services.factory.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomServiceImpl implements RoomService {

    @Autowired
    private EntityRepository entityRepository;

    @Override
    public void save(Room room) {
        entityRepository.add(room);
    }

    @Override
    public List<Room> getAll() {
        return entityRepository.getRooms();
    }
}
