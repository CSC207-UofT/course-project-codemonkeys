package Commands;

import Assets.DataAccessInterface;
import Interfaces.ClientInterface;
import Users.User;


/**
 * This Class is a Command that fetches and displays price information on Asset via, for example, YahooFinance API.
 */
public class CheckPrice extends Command{

    public CheckPrice(User initiator, ClientInterface client, String[] args, DataAccessInterface api) {
        super(initiator, client, args, api);
    }

    /**
     * Fetches and displays price information to the Client.
     * this.args syntax: [String: symbol]
     * @returns if successful
     */
    @Override
    public boolean execute() {
        if(this.args.length != 1) return false;
        double price = -1;
        try{
            //TODO use API to get price
            //price = ...
        }
        catch (Exception e){
            return false;
        }
        this.client.output("Price of "+ this.args[0]+" is currently $"+price+" USD.");
        return true;
    }

    @Override
    public String help() {
        return "CheckPrice: collects and formats price information to display\n" +
                "Syntax: checkprice [symbol]\n" +
                "Usage: checkprice TSLA\n\n";
    }

    @Override
    public String name() {
        return "checkprice";
    }
}
