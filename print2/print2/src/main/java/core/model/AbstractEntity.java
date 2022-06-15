package core.model;

import java.time.LocalDateTime;

public abstract class AbstractEntity {
    private long id;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public AbstractEntity(long id, int version) {
        this.id = id;
        this.version = version;
        this.createdAt = java.time.LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
