package com.ada.holiday_party_planning.model;

import com.ada.holiday_party_planning.enums.GuestStatusEnum;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "guest_id", nullable = false)
    private UUID guestId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private GuestStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "event_id", nullable = false)
    private Event event;

    @Column(name = "is_confirmed", nullable = false)
    private boolean isConfirmed;

    public Guest() {}

    public Guest(UUID guestId, GuestStatusEnum status, String email, String name, Event event, boolean isConfirmed) {
        this.guestId = guestId;
        this.status = status;
        this.email = email;
        this.name = name;
        this.event = event;
        this.isConfirmed = isConfirmed;

    }

    public UUID getGuestId() {
        return guestId;
    }

    public void setGuestId(UUID guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GuestStatusEnum getStatus() {
        return status;
    }

    public void setStatus(GuestStatusEnum status) {
        this.status = status;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }
}
