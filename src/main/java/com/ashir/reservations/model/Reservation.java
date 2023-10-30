package com.ashir.reservations.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @Column(name = "reservation_code", length = 5)
    private String reservationCode;
    @Column(name = "reservation_date", nullable = false)
    private LocalDate reservationDate;
    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;
    @Column(name = "customer_document", nullable = false, length = 15)
    private String customerDocument;
    @Column(name = "reservation_price", nullable = false)
    private BigDecimal reservationPrice;
    @ManyToOne
    @JoinColumn(name = "room_number", insertable = false, updatable = false)
    private Room room;
    @ManyToOne
    @JoinColumn(name = "customer_document", insertable = false, updatable = false)
    private Customer customer;

    public Reservation() {
    }

    public Reservation(String reservationCode, LocalDate reservationDate, Integer roomNumber, String customerDocument, BigDecimal reservationPrice, Room room, Customer customer) {
        this.reservationCode = reservationCode;
        this.reservationDate = reservationDate;
        this.roomNumber = roomNumber;
        this.customerDocument = customerDocument;
        this.reservationPrice = reservationPrice;
        this.room = room;
        this.customer = customer;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCustomerDocument() {
        return customerDocument;
    }

    public void setCustomerDocument(String customerDocument) {
        this.customerDocument = customerDocument;
    }

    public BigDecimal getReservationPrice() {
        return reservationPrice;
    }

    public void setReservationPrice(BigDecimal reservationPrice) {
        this.reservationPrice = reservationPrice;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
