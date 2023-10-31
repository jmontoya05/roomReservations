package com.ashir.reservations.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @Column(name = "room_number")
    private Integer roomNumber;
    @Column(name = "base_price", nullable = false)
    private BigDecimal basePrice;
    @Column(name = "room_type_id", nullable = false)
    private Integer roomTypeId;
    @ManyToOne
    @JoinColumn(name = "room_type_id", insertable = false, updatable = false)
    private RoomType roomType;

    public Room() {
    }

    public Room(Integer roomNumber, BigDecimal basePrice, Integer roomTypeId, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.roomTypeId = roomTypeId;
        this.roomType = roomType;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
