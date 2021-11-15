package team.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double commission;
    private Long budged;

    public Team() {
    }

    public Team(String name, double commission, Long budged) {
        this.name = name;
        this.commission = commission;
        this.budged = budged;
    }

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
        return "Team{"
                + "id=" + id
                + ", name='" + name
                + ", commission='" + commission
                + ", budged='" + budged
                + '}';
    }
}
