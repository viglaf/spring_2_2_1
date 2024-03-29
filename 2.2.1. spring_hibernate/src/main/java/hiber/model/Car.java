package hiber.model;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int carId;
    @Column
    private String model;
    @Column
    private int series;

    public Car() {
    }

    public Car(String model, int series) {
        this.series = series;
        this.model = model;
    }

    public int getSeries() {return series;}

    public void setSeries(int series) {this.series = series;}

    public String getModel() {return model;}

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car model: " + getModel() + "; Car series: " + getSeries();
    }


}
