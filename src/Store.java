import Product.VehicleType;
import Product.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int storeId;
    VehicleInventoryManagement vehicleInventoryManagement;
    Location location;
    List<Reservation> reservations = new ArrayList<>();

    public List<Vehicle> getVehicles(VehicleType vehicleType){
        return vehicleInventoryManagement.getVehicles();
    }

    //addVehicles, update vehicles, use inventory management to update those

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleInventoryManagement = new VehicleInventoryManagement(vehicles);
    }


    public Reservation createReservation(Vehicle vehicle, User user){
        Reservation reservation = new Reservation();
        reservation.createReservation(user, vehicle);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationId){
        for(Reservation res: reservations){
            if(res.reservationId == reservationId){
                res.reservationStatus = ReservationStatus.COMPLETED;
            }
        }
        return true;
    }

    //update reservation
}
