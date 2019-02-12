import java.util.Objects;
import java.util.Set;

public class Cinema implements Comparable<Cinema>{
    private String name;
    private int seats;
    private Set<String> films;

    public Cinema(String name, int seats, Set<String> films) {
        this.name = name;
        this.seats = seats;
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public int getSeats() {
        return seats;
    }

    public Set<String> getFilms() {
        return films;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setFilms(Set<String> films) {
        this.films = films;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return seats == cinema.seats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seats);
    }

    @Override
    public int compareTo(Cinema cinema) {
        return name.compareTo(cinema.getName());
    }

    @Override
    public String toString() {
        return "Кинотеатр:"+ name;
    }
}
