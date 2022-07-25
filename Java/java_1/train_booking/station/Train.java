/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package station;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class Train extends Gas_station {

    private String train_name;
    private int seat;
    private double depart_time;
    private String depart_place;
    public int avai_seat;

    public Train() {
    }

    public Train(String train_name, int seat, double depart_time, String depart_place, int avai_seat, String tcode, String ccode, int booked) {
        super(tcode, ccode, booked);
        this.train_name = train_name;
        this.seat = seat;
        this.depart_time = depart_time;
        this.depart_place = depart_place;
        this.avai_seat = avai_seat;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(double depart_time) {
        this.depart_time = depart_time;
    }

    public String getDepart_place() {
        return depart_place;
    }

    public void setDepart_place(String depart_place) {
        this.depart_place = depart_place;
    }

    public int getAvai_seat() {
        return avai_seat;
    }

    public void setAvai_seat(int avai_seat) {
        this.avai_seat = avai_seat;
    }

    @Override
    public void add() {
        this.train_name = Utils.getString("Train Name: ");
        this.seat = Utils.getNumber("Seat: ");
        do {
            int bkd = Utils.getNumber("Booked: ");
            if (bkd > this.seat) {
                System.out.println("Out of Seats, try again");
                continue;
            }
            this.booked = bkd;
            break;
        } while (true);
        this.avai_seat = this.seat - this.booked;
        this.depart_time = Utils.getDouble("Depart Time: ");
        this.depart_place = Utils.getString("Depart Place: ");
    }

    @Override
    public String tostring() {
        return tcode + "\t| \t" + train_name + "\t\t|\t" + seat + "\t| \t" + booked + "\t| \t" + depart_time + "\t\t| \t" + depart_place + "\t\t| \t" + this.avai_seat;
    }
}
