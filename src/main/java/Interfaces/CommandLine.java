package Interfaces;

import java.util.Scanner;
import java.util.UUID;

import Controller.ControllerLogic;
import Controller.UserManager;
import Entities.Admin;
import Entities.User;

public class CommandLine {
    private String cur_user = "Finance_Simulation";
    private ControllerLogic logic = new ControllerLogic();
    private Scanner scan = new Scanner(System.in);
    private YahooFinanceAPI api = new YahooFinanceAPI();
    private String admin;

    public CommandLine(){
        System.out.println(this.cur_user+":Please Enter Admin Name and deposit money");
        String[] input = this.scan.nextLine().split(" ");
        this.cur_user = input[0];  // TODO check input type
        this.admin = this.cur_user;
        this.logic.joinAdmin(this.cur_user, Integer.parseInt(input[1]));
        this.adminAccoint();
    }

    public void adminAccoint() {
        System.out.println(this.cur_user + "_Admin $");
        String command = this.scan.nextLine();
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "leave":
                this.logic.leave(this.cur_user);
                this.cur_user = "Finance_Simulation";
                this.login();
            case "price":
                System.out.println(this.api.getCureentPrice(parts[1]));
                this.adminAccoint();
            case "vote":
                this.logic.createVote(this.admin, parts[1], Double.parseDouble(parts[2]));
                System.out.println(this.cur_user+": Vote initiated.");
                this.adminAccoint();
            case "viewvote":
                System.out.println(this.logic.viewVotes());
                this.adminAccoint();
            case "upvote":
                System.out.println("Please enter id for the vote");
                String id = this.scan.nextLine();
                UUID uid = UUID.fromString(id);
                this.logic.upVote(uid, this.cur_user);
                int allVotersSoFar = this.logic.voterNumer(uid);
                int allUsers = this.logic.userNumber();
                if (allVotersSoFar < allUsers) {
                    System.out.println(this.cur_user+": upvote received.");
                }
                if (this.logic.checkVoteFinish(uid)) {
                    System.out.println(this.cur_user+": Vote finished. " + id + " is approved.");
                    this.logic.transferAttempt(uid);
                } else {
                    System.out.println(this.cur_user+": Vote finished. " + id + " is declined.");
                }
                this.adminAccoint();
            case "downvote":
                uid = UUID.fromString(parts[1]);
                allVotersSoFar = this.logic.voterNumer(uid);
                allUsers = this.logic.userNumber();
                this.logic.downVote(uid, this.cur_user);
                if (allVotersSoFar < allUsers) {
                    System.out.println(this.cur_user+": downvote received.");
                }
                if (this.logic.checkVoteFinish(uid)) {
                    System.out.println(this.cur_user+": Vote finished. " + parts[1] + " is approved.");
                    this.logic.transferAttempt(uid);
                } else {
                    System.out.println(this.cur_user+": Vote finished. " + parts[1] + " is declined.");
                }
                this.adminAccoint();
            default:
                System.out.println("Invalid input. Enter again!");
                this.adminAccoint();
        }
    }

    public void login(){
        System.out.println(this.cur_user+" $");
        String command = this.scan.nextLine();
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "createuser":
                this.cur_user = parts[1];
                this.logic.join(parts[1], Integer.parseInt(parts[2]));  // TODO check input type
                this.userAccoint();
            case "join":
                this.cur_user = parts[1];
                this.logic.join(parts[1], Integer.parseInt(parts[2]));  // TODO check input type
                this.userAccoint();
        }
    }

    public void userAccoint() {
        System.out.println(this.cur_user+"_User $");
        String command = this.scan.nextLine();
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "leave":
                this.logic.leave(this.cur_user);
                this.cur_user = "Finance_Simulation";
                this.login();
            case "price":
                System.out.println(this.api.getCureentPrice(parts[1]));
                this.userAccoint();
            case "vote":
                this.logic.createVote(this.admin, parts[1], Double.parseDouble(parts[2]));
                System.out.println(this.cur_user+": Vote initiated.");
                this.userAccoint();
            case "viewvote":
                System.out.println(this.logic.viewVotes());
                this.userAccoint();
            case "upvote":  // TODO: check input type
                UUID uid = UUID.fromString(parts[1]);
                this.logic.upVote(uid, this.cur_user);
                int allVotersSoFar = this.logic.voterNumer(uid);
                int allUsers = this.logic.userNumber();
                if (allVotersSoFar < allUsers) {
                    System.out.println(this.cur_user+": upvote received.");
                }
                if (this.logic.checkVoteFinish(uid)) {
                    System.out.println(this.cur_user+": Vote finished. " + parts[1] + " is approved.");
                    this.logic.transferAttempt(uid);
                } else {
                    System.out.println(this.cur_user+": Vote finished. " + parts[1] + " is declined.");
                }
                this.userAccoint();
            case "downvote":
                uid = UUID.fromString(parts[1]);
                allVotersSoFar = this.logic.voterNumer(uid);
                allUsers = this.logic.userNumber();
                this.logic.downVote(uid, this.cur_user);
                if (allVotersSoFar < allUsers) {
                    System.out.println(this.cur_user+": downvote received.");
                }
                if (this.logic.checkVoteFinish(uid)) {
                    System.out.println(this.cur_user+": Vote finished. " + parts[1] + " is approved.");
                    this.logic.transferAttempt(uid);
                } else {
                    System.out.println(this.cur_user+": Vote finished. " + parts[1] + " is declined.");
                }
                this.userAccoint();
            default:
                System.out.println("Invalid input. Enter again!");
                this.userAccoint();
        }
    }

}
