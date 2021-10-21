package edu.parinya.softarchdesign.structural;

import java.util.LinkedHashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable {
    private Set<HealthcareServiceable> members = new LinkedHashSet<HealthcareServiceable>();

    public void addMember(HealthcareServiceable member) {
        this.members.add(member);
    }

    public void removeMember(HealthcareServiceable member) {
        this.members.remove(member);
    }

    @Override
    public void service() {
        this.members.forEach((item) -> {
            item.service();
        });
    }

    @Override
    public double getPrice() {
        double allPrice = 0f;
        for (HealthcareServiceable members : this.members) {
            allPrice += members.getPrice();
        }
        return allPrice;
    }
}
