package com.company.gamestates;

import com.company.gamestates.interfaces.State;
import com.company.interfaces.Displayable;
import com.company.interfaces.Updateable;

import java.awt.*;

public abstract class AbstractState implements State, Displayable, Updateable {
    @Override
    public void display(Graphics g) {

    }
}
