package com.ib.library.repository;

import com.ib.library.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationInterface extends CrudRepository<Integer, Reservation> {
}
