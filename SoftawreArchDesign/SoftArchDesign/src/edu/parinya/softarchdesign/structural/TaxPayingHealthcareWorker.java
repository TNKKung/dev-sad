package edu.parinya.softarchdesign.structural;

public class TaxPayingHealthcareWorker extends HealthcareWorkerDecorator {

    public TaxPayingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        // TODO Auto-generated constructor stub
        System.out.println("Decorate " + worker.getName() + " with TaxPaying.");
    }

    @Override
    public double getPrice() {
        double taxPay = 0.1;
        return super.getPrice() * (1.0 + taxPay);
    }

}
