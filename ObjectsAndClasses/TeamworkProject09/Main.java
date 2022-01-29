package Jan25.TeamworkProject09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Team team = null;

        int n = Integer.parseInt(scanner.nextLine());

        List<Team> teamList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] creatorAndTeam = scanner.nextLine().split("-");
            team = new Team(creatorAndTeam[1], new ArrayList<>(), creatorAndTeam[0]);

            boolean isContained = teamList.stream().anyMatch(e -> e.getName().equals(creatorAndTeam[1]));
            boolean isCreator = teamList.stream().anyMatch(e -> e.getCreator().equals(creatorAndTeam[0]));

            if (!isContained && !isCreator) {
                teamList.add(team);
                team.getMembers().add(team.getCreator());
                System.out.println("Team " + creatorAndTeam[1] + " has been created by " + creatorAndTeam[0] + "!");
            } else if (isContained && !isCreator) {
                System.out.println("Team " + creatorAndTeam[1] + " was already created!");
            } else if (isCreator) {
                System.out.println(creatorAndTeam[0] + " cannot create another team!");
            }
        }


        String input = scanner.nextLine();

        while (!input.equals("end of assignment")) {
            String[] userAndTeamToJoin = input.split("->");
            String user = userAndTeamToJoin[0];
            String teamToJoin = userAndTeamToJoin[1];
            boolean alreadyIn = false;
            boolean teamExist = false;
            Team neededTeam = null;
            for (Team team1 : teamList) {
                if (team1.getName().equals(teamToJoin)) {
                    teamExist = true;
                    neededTeam = team1;
                    break;
                }
            }

            if (!teamExist) {
                System.out.println("Team " + teamToJoin + " does not exist!");
            } else {

                for (String member : neededTeam.getMembers()) {
                    if (member.equals(user)){
                        System.out.println("Member " + user + " cannot join team " + neededTeam.getName());
                        alreadyIn = true;
                        break;
                    }
                }
                if (!alreadyIn) {
                    neededTeam.addMember(user);
                }

            }


            input = scanner.nextLine();
        }

        teamList.stream().sorted((e1,e2) -> {

            if (e1.getMembers().size() == e2.getMembers().size()){
                return e1.getName().compareTo(e2.getName());
            }else if (e1.getMembers().size() > e2.getMembers().size()){
                return -1;
            }else if (e1.getMembers().size() < e2.getMembers().size()){
                return 1;
        }else {
                return 0;
            }}).forEach(e -> {
            if (e.getMembers().size() == 1){
                System.out.println("Teams to disband:");
                System.out.println(e.getName());
            }else {
                System.out.println(e.getName());
                for (String member : e.getMembers()) {
                    if (member.equals(e.getCreator())){
                        System.out.printf("- %s%n", e.getCreator());
                    }else {
                        System.out.printf("-- %s%n", member);
                    }

                }
            }
        });

    }
}


//            System.out.println(team1.getName() + team1.getCreator() + team1.getMembers().toString());