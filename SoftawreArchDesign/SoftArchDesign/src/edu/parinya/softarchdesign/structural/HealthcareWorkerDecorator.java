package edu.parinya.softarchdesign.structural;

public class HealthcareWorkerDecorator extends HealthcareWorker {
    public HealthcareWorker worker;

    public HealthcareWorkerDecorator(HealthcareWorker worker) {
        super(worker);

        this.worker = worker;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void service() {
        this.worker.service();

    }

    public double getPrice() {
        return this.worker.getPrice();
    }

}
