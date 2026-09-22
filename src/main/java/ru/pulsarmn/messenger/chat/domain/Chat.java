package ru.pulsarmn.messenger.chat.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(schema = "public", name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    private UUID id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type = Type.DIRECT;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    public enum Type {
        DIRECT,
        GROUP
    }

    public Chat() {
    }

    public Chat(UUID id, Type type, Instant createdAt) {
        this.id = id;
        this.type = type;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Chat chat = (Chat) object;
        return Objects.equals(id, chat.id) && type == chat.type && Objects.equals(createdAt, chat.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, createdAt);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", type=" + type +
                ", createdAt=" + createdAt +
                '}';
    }
}
