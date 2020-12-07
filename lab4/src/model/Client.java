package model;

public class Client {
    private int age;
    private final String FirstName;
    private final String LastName;
//    private int roomId = -1;

    public Client(int age, String firstName, String lastName) {
        this.age = age;
        FirstName = firstName;
        LastName = lastName;
    }

//    public int getRoomId(){
//        return this.roomId;
//    }
//    public void setRoomId(int roomId) {
//        this.roomId = roomId;
//    }

    public boolean isOldEnough(){
        return this.age >= 18;
    }
    @Override
    public String toString() {
        return "Client{" +
                "age=" + age +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
//                    ", roomId=" + roomId +
}
