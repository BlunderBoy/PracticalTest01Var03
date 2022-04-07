package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        int rezultat =  Integer.parseInt(intent.getStringExtra("rezultat"));

        if (action.equals("adunare")) {
            Log.e("Rezultate adunare: ", String.valueOf(rezultat));
        } else if (action.equals("scadere")) {
            Log.e("Rezultate scadere: ", String.valueOf(rezultat));
        }
    }
}
