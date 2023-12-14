package com.zkteco.busbookingservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "bus_booking_db")
public class BusBookingDao {


    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String bookingId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "BUS_ID")
    private String busId;

    @Column(name = "SEATS")
    private long seats;

    @Column(name = "BOOKING_TIME")
//    @CreationTimestamp
    private String bookingTime;

    @Column(name = "BOOKING_STATUS")
    private String bookingStatus;

    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;

    @Column(name = "BUS_FAIR")
    private int fair;

    @Column(name = "CONTACT_NUMBER")
    private Long contactNumber;

    @Column(name = "ORIGIN")
    private String origin;

    @Column(name = "DESTINATION")
    private String destination;

    @Column(name = "DEPARTURE_DATE_TIME")
    private String departureDateTime;


}
