package team.dto.request;

public class PlayerRequestDto {
    private String name;
    private String surname;
    private int age;
    private int experience;
    private Long teamId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "TeamResponseDto{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", experience=" + experience
                + ", teamId=" + teamId
                + '}';
    }
}
