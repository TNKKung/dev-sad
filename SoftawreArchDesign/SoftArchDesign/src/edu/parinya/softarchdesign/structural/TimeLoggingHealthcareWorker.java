package edu.parinya.softarchdesign.structural;

import java.util.Date;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator {
    Date date = new Date();

    public TimeLoggingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        // TODO Auto-generated constructor stub
        System.out.println("Decorate " + worker.getName() + " with TimeLogging.");
    }

    public Object getDate() {
        return this.date;
    }

    @Override
    public void service() {
        // TODO Auto-generated method stub
        System.out.print(getDate() + ": ");
        super.service();
    }

}
