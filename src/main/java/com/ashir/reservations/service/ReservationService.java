package com.ashir.reservations.service;

import com.ashir.reservations.dto.ReservationRequest;
import com.ashir.reservations.dto.ReservationResponse;
import com.ashir.reservations.model.Customer;
import com.ashir.reservations.model.Reservation;
import com.ashir.reservations.model.Room;
import com.ashir.reservations.model.RoomType;
import com.ashir.reservations.repository.CustomerRepository;
import com.ashir.reservations.repository.ReservationRepository;
import com.ashir.reservations.repository.RoomRepository;
import com.ashir.reservations.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;
    private final RoomTypeRepository roomTypeRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository, CustomerRepository customerRepository, RoomTypeRepository roomTypeRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.customerRepository = customerRepository;
        this.roomTypeRepository = roomTypeRepository;
    }

    public ReservationResponse saveReservation(ReservationRequest reservationRequest) {
        Integer roomNumber = reservationRequest.getRoomNumber();
        String customerDocument = reservationRequest.getCustomerDocument();

        Room room = roomRepository.findById(roomNumber).orElse(null);
        Customer customer = customerRepository.findById(customerDocument).orElse(null);

        if (room == null || customer == null) {
            throw new RuntimeException();
        }
        LocalDate reservationDate = reservationRequest.getReservationDate();
        LocalDate currentDate = LocalDate.now();

        if (reservationDate.isBefore(currentDate)){
            throw new RuntimeException();
        }

        BigDecimal basePrice = room.getBasePrice();
        RoomType roomType = roomTypeRepository.findById(room.getRoomTypeId()).orElse(null);

        BigDecimal discount = BigDecimal.valueOf(0);
        if(roomType != null){
            if (roomType.getRoomType().equals("Premium")){
                discount = basePrice.multiply(BigDecimal.valueOf(0.05));
            }
        } else {
            throw new RuntimeException();
        }

        BigDecimal reservationPrice = basePrice.subtract(discount);
        String reservationCode = reservationCodeGenerator();

        Reservation reservation = new Reservation(reservationCode,reservationDate,roomNumber,customerDocument,reservationPrice);
        reservationRepository.save(reservation);

        return new ReservationResponse(reservation.getReservationCode(), reservation.getRoomNumber(), reservation.getReservationDate(), reservation.getReservationPrice());
    }

    private String reservationCodeGenerator(){
        String validCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom random = new SecureRandom();
        int lengthCode = 5;
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < lengthCode; i++) {
            int index = random.nextInt(validCharacters.length());
            code.append(validCharacters.charAt(index));
        }

        return code.toString();
    }
}
