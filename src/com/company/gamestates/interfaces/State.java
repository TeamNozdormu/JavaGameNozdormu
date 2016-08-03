package com.company.gamestates.interfaces;

import com.company.interfaces.Displayable;
import com.company.interfaces.Updateable;

import java.awt.*;

public interface State extends Displayable, Updateable {

    void display(Graphics g);
}
