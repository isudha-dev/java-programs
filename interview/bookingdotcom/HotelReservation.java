package interview.bookingdotcom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HotelReservation {

    public static void main(String[] args) {
        test();
    }
    // group reservations by hotel name
// sort reservations by start + end
// if one of reservations start > available.end then filter it
// if one of reservations end < available.start then filter it
// loop in hotels.reservations
// for the first record, reduce 1 of the available room for current hotel // do while's first iteration
// if iterating reservation has next
// iterating.start < prev.end
// reduce 1 of the available room for current hotel
// show hotels which has available room size > 0

    static class Hotel {
        String name;
        int availableRooms;

        public Hotel(String name, int availableRooms) {
            this.name = name;
            this.availableRooms = availableRooms;
        }

        public int getAvailableRooms() {
            return availableRooms;
        }

        public void setAvailableRooms(int availableRooms) {
            this.availableRooms = availableRooms;
        }
    }

    static class Reservation {
        Hotel hotel;
        LocalDate checkIn;
        LocalDate checkOut;

        public Reservation(Hotel hotel, LocalDate checkIn, LocalDate checkOut) {
            this.hotel = hotel;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }

        public Hotel getHotel() {
            return hotel;
        }

        public LocalDate getCheckIn() {
            return checkIn;
        }

        public LocalDate getCheckOut() {
            return checkOut;
        }
    }

    static LocalDate setDate(String date){
        return LocalDate.parse(date);
    }

    static void test() {
        Hotel hilton = new Hotel("Hilton", 3);
        Hotel stRegis = new Hotel("Saint Regis", 1);
        Hotel fourSeasons = new Hotel("Four Seasons", 4);
        List<Reservation> bookedReservations = new ArrayList<>(List.of(
                new Reservation(hilton, setDate("2020-01-04"), setDate("2020-12-31")), // filtered
                new Reservation(hilton, setDate("2021-01-04"), setDate("2021-01-13")), // uses room 101
                new Reservation(hilton, setDate("2021-02-01"), setDate("2021-02-03")), // filtered
                new Reservation(hilton, setDate("2021-01-02"), setDate("2021-01-03")), // uses room 101
                new Reservation(hilton, setDate("2021-01-01"), setDate("2021-01-10")), // uses room 102
                new Reservation(hilton, setDate("2021-01-01"), setDate("2021-01-10")), // uses room 103
                new Reservation(stRegis, setDate("2021-01-01"), setDate("2021-01-03")),
                new Reservation(fourSeasons, setDate("2021-01-01"), setDate("2021-01-03"))
        ));

        bookedReservations = bookedReservations.stream()
                .sorted(Comparator.comparing(Reservation::getCheckIn)
                        .thenComparing(Reservation::getCheckOut))
                .collect(Collectors.toList());

        List<Hotel> availableHotels = checkAvailability(bookedReservations, setDate("2021-01-01"), setDate("2021-01-10"));

        System.out.println(availableHotels.size());
    }

    private static List<Hotel> checkAvailability(List<Reservation> reservations, LocalDate checkIn, LocalDate checkOut) {
        Map<Hotel, List<Reservation>> hotelReservationMap = reservations.stream()
                .collect(Collectors.groupingBy(Reservation::getHotel));

        for (Map.Entry<Hotel, List<Reservation>> hotelReservations : hotelReservationMap.entrySet()) {
            List<Reservation> filteredReservations = hotelReservations.getValue().stream()
                    .filter(reservation -> !(reservation.getCheckIn().isAfter(checkOut) || reservation.getCheckOut().isBefore(checkIn)))
                    .toList();

            for (int i = 0; i < filteredReservations.size(); i++) {
                int availableRooms = hotelReservations.getKey().getAvailableRooms();
                if (i == 0) {
                    hotelReservations.getKey().setAvailableRooms(availableRooms - 1);
                } else {
                    boolean useOneMoreRoom = filteredReservations.get(i).getCheckIn().isBefore(filteredReservations.get(i - 1).getCheckOut());
                    if (useOneMoreRoom) {
                        hotelReservations.getKey().setAvailableRooms(availableRooms - 1);
                    }
                }
            }
        }
        return hotelReservationMap.keySet().stream().filter(hotel -> hotel.availableRooms > 0).collect(Collectors.toList());
    }

}
