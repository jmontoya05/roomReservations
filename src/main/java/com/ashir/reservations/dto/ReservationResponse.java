package com.ashir.reservations.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReservationResponse {
    private String reservationCode;
    private Integer roomNumber;
    private LocalDate reservationDate;
    private BigDecimal reservationPrice;

    public ReservationResponse(String reservationCode, Integer roomNumber, LocalDate reservationDate, BigDecimal reservationPrice) {
        this.reservationCode = reservationCode;
        this.roomNumber = roomNumber;
        this.reservationDate = reservationDate;
        this.reservationPrice = reservationPrice;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public BigDecimal getReservationPrice() {
        return reservationPrice;
    }

    public void setReservationPrice(BigDecimal reservationPrice) {
        this.reservationPrice = reservationPrice;
    }
}
