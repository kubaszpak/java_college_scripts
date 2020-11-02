package cars;

public abstract class Vehicle implements IDiritable{

    final protected int productionYear = 2000;

    public void horn(){
        System.out.println("Beep Beep!");
    }
 //TODO: to make this class implement IDiritable it cannot be abstract
// public void dirty() {
//     this.dirty = false;
// }
//
//    public void clean() {
//        this.dirty = true;
//    }
}
