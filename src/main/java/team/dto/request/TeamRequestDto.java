package team.dto.request;

public class TeamRequestDto {
    private String name;
    private double commission;
    private Long budged;

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
                + ", name='" + name
                + ", commission='" + commission
                + ", budged='" + budged
                + '}';
    }
}
