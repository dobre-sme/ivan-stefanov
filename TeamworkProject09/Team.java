package Jan25.TeamworkProject09;

import java.util.List;

public class Team {
    private String name;
    private List<String> members;
    private String creator;

    public Team(String name, List<String> members, String creator) {
        this.name = name;
        this.members = members;
        this.creator = creator;
    }

    public void addMember(String newPLayer){
        this.members.add(newPLayer);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
