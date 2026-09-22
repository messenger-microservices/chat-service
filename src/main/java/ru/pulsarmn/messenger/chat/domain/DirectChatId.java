package ru.pulsarmn.messenger.chat.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.UUID;


@Embeddable
public class DirectChatId {

    @Column(name = "lower_user_id")
    private UUID lowerUserId;

    @Column(name = "higher_user_id")
    private UUID higherUserId;

    public DirectChatId() {}

    public DirectChatId(UUID lowerUserId, UUID higherUserId) {
        if (lowerUserId.compareTo(higherUserId) > 0) {
            this.lowerUserId = higherUserId;
            this.higherUserId = lowerUserId;
        } else {
            this.lowerUserId = lowerUserId;
            this.higherUserId = higherUserId;
        }
    }

    public UUID getLowerUserId() {
        return lowerUserId;
    }

    public void setLowerUserId(UUID lowerUserId) {
        this.lowerUserId = lowerUserId;
    }

    public UUID getHigherUserId() {
        return higherUserId;
    }

    public void setHigherUserId(UUID higherUserId) {
        this.higherUserId = higherUserId;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        DirectChatId that = (DirectChatId) object;
        return Objects.equals(lowerUserId, that.lowerUserId) && Objects.equals(higherUserId, that.higherUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lowerUserId, higherUserId);
    }

    @Override
    public String toString() {
        return "DirectChatId{" +
                "lowerUserId=" + lowerUserId +
                ", higherUserId=" + higherUserId +
                '}';
    }
}
