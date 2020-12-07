package view;

import controller.Controller;

public abstract class View implements Form{

    protected Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

}
