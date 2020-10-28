package domain;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<TicketInfo> {
    @Override
    public int compare(TicketInfo o1, TicketInfo o2) {
     return o1.getTime() - o2.getTime();
    }
}

