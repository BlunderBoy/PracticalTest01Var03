package ro.pub.cs.systems.eim.practicaltest01var03;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Var03Service extends Service {

    Thread worker;

    public PracticalTest01Var03Service() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        int number1 = intent.getIntExtra("unu", 0);
        int number2 = intent.getIntExtra("doi", 0);

        worker = new ProcessingThread(number1, number2, this);
        worker.start();

        return START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        try {
            worker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}