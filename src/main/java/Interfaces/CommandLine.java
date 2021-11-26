package Interfaces;

public class CommandLine implements ClientInterface{

    @Override
    public void input(String s) {

    }

    @Override
    public void output(String s) {
        System.out.println(s);
    }
}
