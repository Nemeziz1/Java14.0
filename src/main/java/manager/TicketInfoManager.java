package manager;

import domain.TicketInfo;
import repository.TicketInfoRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketInfoManager {
    private TicketInfoRepository repository;

    public void save(TicketInfo trip) {
        int length = trips.length + 1;
        TicketInfo[] tmp = new TicketInfo[length];
        System.arraycopy(trips, 0, tmp, 0, trips.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = trip;
        trips = tmp;
    }

    public TicketInfoManager(TicketInfoRepository repository) {
        this.repository = repository;
    }

    private TicketInfo[] trips = new TicketInfo[0];

    public TicketInfo[] findAll(String from, String to, Comparator<TicketInfo> comparator) {

        TicketInfo[] tmp = repository.findAll();
        for (TicketInfo trip : tmp) {
            if (trip.getFrom() == from && trip.getTo() == to) {
                save(trip);
                Arrays.sort(trips, comparator);
            }
        }
        return trips;
    }
}
