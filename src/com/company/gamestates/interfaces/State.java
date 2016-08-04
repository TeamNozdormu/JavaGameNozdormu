package com.company.gamestates.interfaces;

import java.awt.*;

public interface State extends Displayable, Updateable {

    void display(Graphics g);
}
