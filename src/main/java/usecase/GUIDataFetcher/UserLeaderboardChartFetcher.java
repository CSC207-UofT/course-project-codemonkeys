package usecase.GUIDataFetcher;

import entities.users.User;
import usecase.DataAccessInterfaceRelay;
import usecase.managers.ExecutionChecker;
import usecase.managers.UserManager;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;
import java.util.*;

public class UserLeaderboardChartFetcher {
    /**
     * Fetches and packages data from backend for presentation on JPanels.
     *
     * Author: Andrew Zhang
     * Version: 1.0
     */
    public static DefaultCategoryDataset getData(DataAccessInterfaceRelay api) {
        /*
         * Prepares data for graphing.
         *
         * Iterate through all registered users, then calculate their voting power and sort the users by their voting
         * powers.
         */

        UserManager userManager = UserManager.getInstance();
        DefaultCategoryDataset series = new DefaultCategoryDataset( );

        TreeMap<Double, ArrayList<String>> votingPowerMap = new TreeMap<>();

        // sort users according to voting power
        Map<UUID, User> userMap = userManager.getUserMap();

        for (UUID id : userMap.keySet()) {
            User user = userMap.get(id);
            double votingPower = ExecutionChecker.getVotingPower(user, api);
            String name = user.getName();

            if (!votingPowerMap.containsKey(votingPower)) {
                votingPowerMap.put(votingPower, new ArrayList<>(List.of(name)));
            } else {
                votingPowerMap.get(votingPower).add(name);
            }
        }

        for (double votingPower : votingPowerMap.descendingKeySet()) {
            for (String name : votingPowerMap.get(votingPower)) {
                series.addValue(votingPower, "", name);
            }
        }
        return series;

    }

}
