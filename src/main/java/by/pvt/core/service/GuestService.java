package by.pvt.core.service;

import by.pvt.core.domain.Guest;
import by.pvt.core.repository.DBGuestRepoHibernate;

public class GuestService implements IGuest
    {
    private final DBGuestRepoHibernate guestRepository;

    public GuestService()
        {
        guestRepository = new DBGuestRepoHibernate();
        }

    public void addGuest(Guest guest)
        {
        guestRepository.addGuest(guest);
        }
    }
