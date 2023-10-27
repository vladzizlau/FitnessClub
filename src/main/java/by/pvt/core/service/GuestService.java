package by.pvt.core.service;

import by.pvt.core.domain.Guest;
import by.pvt.core.repository.DBGuestRepoHibernate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class GuestService implements IGuest
    {
    private final DBGuestRepoHibernate guestRepository;

    public GuestService(DBGuestRepoHibernate dbGuestRepoHibernate)
        {
        guestRepository = dbGuestRepoHibernate;
        }

    public void addGuest(Guest guest)
        {
        guestRepository.addGuest(guest);
        }
    }
