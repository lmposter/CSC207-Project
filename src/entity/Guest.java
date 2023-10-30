package entity;

import java.util.UUID;

public class Guest implements User {
    private String guestId;
    private String guestName;

    public Guest() {
        this.guestId = UUID.randomUUID().toString();
        this.guestName = "Guest" + guestId;
    }

    @Override
    public String getId() {
        return guestId;
    }

    @Override
    public String getName() {
        return guestName;
    }
}
