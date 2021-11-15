package team.dto.response;

public class TeamResponseDto {
    private Long id;
    private String name;
    private double commission;
    private Long budged;

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

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public Long getBudged() {
        return budged;
    }

    public void setBudged(Long budged) {
        this.budged = budged;
    }

    @Override
    public String toString() {
        return "TeamRequestDto{"
                + " id='" + id
                + ", name='" + name
                + ", commission='" + commission
                + ", budged='" + budged
                + '}';
    }
}
