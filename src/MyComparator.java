public class MyComparator implements java.util.Comparator<Cinema> {
    @Override
    public int compare(Cinema cinema, Cinema t1) {
        return Integer.compare(cinema.getSeats(), t1.getSeats());
    }
}
