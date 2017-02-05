package com.chrisyazbek.holla;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

/**
 * Created by reza on 2017-02-04.
 */
public class Notifyer { //@chris You said Kontacts.....
    private static Notifyer ourInstance = new Notifyer();

    public List<ContactLocation> toContactAtLocation;

    public static Notifyer getInstance() {
        return ourInstance;
    }

    private Notifyer() {
        toContactAtLocation = new ArrayList<ContactLocation>();
    }

    public void AddNotifier(String phone, String location)
    {
        ContactLocation cl = new ContactLocation();
        cl.Phone = phone;
        cl.Location = location;
        toContactAtLocation.add(cl);
    }

    public void RemoveNotifier(String phone, String location)
    {
        ContactLocation toDelete = null;
        for (ContactLocation c : toContactAtLocation) {
            if (c.Phone == phone && c.Location == location) {
                toDelete = c;
                break;
            }
        }
        if (toDelete != null)
            toContactAtLocation.remove(toDelete);
    }

    //TODO ADD LOCATION TO START SIGNALING contacts.

}
