package com.ib.library.service.impl;

import com.ib.library.model.Reservation;
import com.ib.library.model.User;
import com.ib.library.model.Work;
import com.ib.library.service.abstraction.ReservationService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ReservationServiceImpl implements ReservationService {

  @Override
  public List<Reservation> findAll() {
    return null;
  }

  @Override
  public List<Reservation> findAllByWork(Work work) {
    return null;
  }

  @Override
  public List<Reservation> findAllByUser(User user) {
    return null;
  }

  @Override
  public Reservation findByUserAndOuvrage(User user, Work work) {
    return null;
  }

  @Override
  public Reservation create(User user, Work work, Date creationDate) {
    return null;
  }

  @Override
  public Reservation delete(Reservation reservation) {
    return null;
  }

  @Override
  public Reservation updateDateLimiteNextResa(Work work) {
    return null;
  }

  @Override
  public int deleteLateResa(List<Reservation> reservationLlateList) {
    return 0;
  }

  @Override
  public List<Reservation> findAllLateResa() {
    return null;
  }

  @Override
  public Reservation update(Reservation reservation) {
    return null;
  }

  @Override
  public int calculateUserPlace(User user, Work work) {
    return 0;
  }
}
