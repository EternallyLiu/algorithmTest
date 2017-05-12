package timeface.eternallyliu.com.testdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("BroadcastReceiver收到的是：" + intent.getStringExtra("tag"));
    }
}
