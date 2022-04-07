package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Context;
import android.content.Intent;

public class ProcessingThread extends Thread {

    int number1;
    int number2;
    Context context;
    boolean flip = true;
    boolean shouldRun = true;

    public ProcessingThread(int number1, int number2, Context context){
        this.number1 = number1;
        this.number2 = number2;
        this.context = context;
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) { }
    }

    private void sendIntent() {
        Intent intent = new Intent();
        if (flip) {
            intent.setAction("adunare");
            intent.putExtra("rezultat", String.valueOf(number1+number2));
        } else {
            intent.setAction("scadere");
            intent.putExtra("rezultat", String.valueOf(number1-number2));
            shouldRun = false;
        }
        flip = !flip;
        context.sendBroadcast(intent);
    }

    @Override
    public void run() {
        while (shouldRun) {
            sendIntent();
            sleep();
        }
    }
}
