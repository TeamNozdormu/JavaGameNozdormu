package com.company.gamestates;

import com.company.gamestates.interfaces.State;
import com.company.gamestates.interfaces.Displayable;
import com.company.gamestates.interfaces.Updateable;

import java.awt.*;

public abstract class AbstractState implements State, Displayable, Updateable {
    @Override
    public void display(Graphics g) {

    }
}
