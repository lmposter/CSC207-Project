package entity;
import java.time.LocalDateTime;

public interface User {
    String getId();
    String getName();
    String getPassword();
    LocalDateTime getCreationTime();
}
