package manager;

import domain.TicketInfo;
import repository.TicketInfoRepository;

import java.util.Arrays;

import java.util.Comparator;


public class TicketInfoManager {
    private TicketInfoRepository repository;

    public void save(TicketInfo trip) {
        repository.add(trip);
    }

    public TicketInfoManager(TicketInfoRepository repository) {
        this.repository = repository;
    }

    public TicketInfo[] findAllComparator(String from, String to, Comparator<TicketInfo> comparator) {
        TicketInfo[] trips = new TicketInfo[0];
        for (TicketInfo trip :  repository.findAll()) {
            if (trip.getFrom().equals(from) && trip.getTo().equals(to)) {
                TicketInfo[] tmp = new TicketInfo[trips.length + 1];
                repository.add(trip);
                System.arraycopy(trips, 0, tmp, 0, trips.length);
                tmp[tmp.length - 1] = trip;
                trips = tmp;
            }
        }
        Arrays.sort(trips, comparator);
        return trips;
    }
}
