package team.dto.response;

public class PlayerResponseDto {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private int experience;
    private Long teamId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
                + "id='" + id
                + ", name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", experience=" + experience
                + ", teamId=" + teamId
                + '}';
    }
}
