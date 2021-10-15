package Manager;

import Client.Admin;
import Client.Portfolio;
import Client.User;

import java.util.*;

public class SessionManager {
    Admin sessionAdmin;
    int id;
    List<Portfolio> products = new ArrayList<>();

    public SessionManager(Integer id) {
        this.id = id;
    }

    public void setAdmin(Admin newAdmin) {
        this.sessionAdmin = newAdmin;
    }

    public void display() {
        System.out.println("Current Session: " + id);
        System.out.println("Admin: " + showAdmin());
        System.out.println("=======================");
        System.out.print("Tradable products: [ ");
        for(Portfolio p: this.products) {
            System.out.print(p.getName() + " ");
        }
        System.out.println("]");
    }

    public String showAdmin() {
        return this.sessionAdmin.getName();
    }

    public void addProduct(Portfolio p) {
        this.products.add(p);
    }

    public boolean tradable(User user, Portfolio portfolio) {
        return this.products.contains(portfolio);
    }

    public void remove(Portfolio portfolio) {
        if (this.products.contains(portfolio)) {
            this.products.remove(portfolio);
            System.out.println("Removed " + portfolio.getName() + " from session tradable list");
        }
    }
}
