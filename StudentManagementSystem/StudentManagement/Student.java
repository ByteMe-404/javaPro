
public class Student {
    private String Name;
    private int Age;
    private int RollNumber;
    private int Id;
    private char Gpa;
    private String Addres;

    public Student(String Name, int Age, int RollNumber, int Id, char Gpa, String Addres) {
        setName(Name);
        setRollNumber(RollNumber);
        setAge(Age);
        setId(Id);
        setGpa(Gpa);
        setAddress(Addres);

    }

    String getName() {
        return Name;
    }

    void setName(String Name) {
        this.Name = Name;
    }

    String getAddress() {
        return Addres;
    }

    void setAddress(String Addres) {
        this.Addres = Addres;
    }

    int getRoll() {
        return RollNumber;
    }

    void setRollNumber(int RollNumber) {
        this.RollNumber = RollNumber;
    }

    int getId() {
        return Id;
    }

    void setId(int Id) {
        this.Id = Id;
    }

    int getAge() {
        return Age;
    }

    void setAge(int Age) {
        this.Age = Age;
    }

    char getGpa() {
        return Gpa;
    }

    void setGpa(char Gpa) {
        this.Gpa = Gpa;
    }

    public void displayInfo() {
        System.out.println("Name        :" + getName());
        System.out.println("Roll Number :" + getRoll());
        System.out.println("Id          :" + getId());
        System.out.println("Age         :" + getAge());
        System.out.println("Gpa         :" + getGpa());
        System.out.println("Address     :" + getAddress());
    }

}
