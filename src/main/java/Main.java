
import Interfaces.GraphicsUserInterface;

public class Main {

import Interfaces.CommandLine;
import UseCases.Commands.*;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        /**
         * Test the help command
         * TODO: implement functionality for other commands
         */

        Object[] a = {Kick.class, Help.class};

        new Help().execute(new ArrayList(Arrays.asList(a)));

        CommandLine cmd = new CommandLine();


}
