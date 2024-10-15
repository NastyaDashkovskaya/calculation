package userinterface.userinterface;



public class Employee {

    private int id;
    private String name;
    private String job;
    private double kofisient = 1.0;
    private double premia = 0.0;

    public Employee(int id, String name, String job, double premia, double kofisient) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.premia = premia;
        this.kofisient = kofisient;
    }
    public Employee(int id, String name, String job, double kofisient) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.kofisient = kofisient;
    }
    public Employee(int id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getPremia() {
        return premia;
    }

    public void setPremia(double premia) {
        this.premia = premia;
    }

    public double countPremia() {
        premia = 195.0 * kofisient;
        return premia;
    }

}