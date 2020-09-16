package com.ib.library.service.abstraction;


import com.ib.library.model.Reservation;
import com.ib.library.model.User;
import com.ib.library.model.Work;

import java.util.Date;
import java.util.List;

public interface ReservationService {


  List<Reservation> findAll();

  List<Reservation> findAllByWork(Work work);

  List<Reservation> findAllByUser(User user);

  Reservation findByUserAndOuvrage(User user, Work work);

  Reservation create(User user, Work work, Date creationDate);

  Reservation delete(Reservation reservation);

  Reservation updateDateLimiteNextResa(Work work);

  int deleteLateResa(List<Reservation> reservationLlateList);

  List<Reservation> findAllLateResa();

  Reservation update(Reservation reservation);

  int calculateUserPlace(User user, Work work);

}
