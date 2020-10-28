package repository;

import domain.TicketInfo;

public class TicketInfoRepository {

    private TicketInfo[] trips = new TicketInfo[0];

    public void add(TicketInfo trip) {
        int length = trips.length + 1;
        TicketInfo[] tmp = new TicketInfo[length];
        System.arraycopy(trips, 0, tmp, 0, trips.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = trip;
        trips = tmp;
    }

    public TicketInfo[] findAll() {
        return trips;
    }

    public void removeById(int id) {
        int length = trips.length - 1;
        TicketInfo[] tmp = new TicketInfo[length];
        int index = 0;
        for (TicketInfo trip : trips) {
            if (trip.getId() != id) {
                tmp[index] = trip;
                index++;
            }
        }
        trips = tmp;
    }
}
