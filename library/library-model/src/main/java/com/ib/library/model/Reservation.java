package com.ib.library.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    public Reservation() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reservation_date", columnDefinition = "DATE")
    private Date reservationDate;

    @Column(name = "notification_date", columnDefinition = "DATE")
    private Date notificationDate;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(targetEntity = Work.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "work_id", referencedColumnName = "id")
    private Work work = new Work();

    public Integer getId() {
        return id;
    }

    public Reservation setId(Integer id) {
        this.id = id;
        return this;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public Reservation setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
        return this;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public Reservation setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Reservation setUser(User user) {
        this.user = user;
        return this;
    }

    public Work getWork() {
        return work;
    }

    public Reservation setWork(Work work) {
        this.work = work;
        return this;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationDate=" + reservationDate +
                ", notificationDate=" + notificationDate +
                '}';
    }
}
