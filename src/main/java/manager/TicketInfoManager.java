package manager;

import domain.TicketInfo;
import repository.TicketInfoRepository;

import java.util.Arrays;

public class TicketInfoManager {
    private final TicketInfoRepository repository;

    public void save(TicketInfo trip) {
        repository.add(trip);
    }

    public TicketInfoManager(TicketInfoRepository repository) {
        this.repository = repository;
    }

    public TicketInfo[] findAll(String from, String to) {
        TicketInfo[] trips = new TicketInfo[0];
        for (TicketInfo trip : repository.findAll()) {
            if (trip.getFrom().equals(from) && trip.getTo().equals(to)) {
                TicketInfo[] tmp = new TicketInfo[trips.length + 1];
                System.arraycopy(trips, 0, tmp, 0, trips.length);
                tmp[tmp.length - 1] = trip;
                trips = tmp;
            }
        }
        Arrays.sort(trips);
        return trips;
    }
}
