/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hello_world;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

/**
 * @author Ahmed
 */
public class Midlet extends MIDlet implements CommandListener {
    Display display = Display.getDisplay(this);
    Form form = new Form("First application");
    Form form2= new Form("second application");
    Form form3= new Form("third application");
    
    
    Command cmExit = new Command("exit", Command.EXIT, 0);
    Command cmNext = new Command("next",Command.SCREEN,0);
    Command cmBack = new Command ("back",Command.EXIT,0);
    

    public void startApp() {
        form.append("Hello World!");
        form.addCommand(cmExit);
        form.addCommand(cmNext);
        form.setCommandListener(this);
        form2.addCommand(cmNext);
        form2.addCommand(cmBack);
        form2.setCommandListener(this);
        display.setCurrent(form); 
        form3.addCommand(cmBack);
        form3.setCommandListener(this);
    }
    
    public void pauseApp() {
        System.out.println("Bonjour");
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c==cmExit)
           notifyDestroyed();
        else
            if((d==form) && (c==cmNext))
             display.setCurrent(form2);
        else
                if((d==form2) && (c==cmNext))
                display.setCurrent(form3);
        else
                    if ((d==form3) && (c==cmBack))
                        display.setCurrent(form2);
         else
                    if ((d==form2) && (c==cmBack))
                        display.setCurrent(form);
                        
        
        
        
    }
}
