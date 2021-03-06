package com.zhanshow.mylibrary.power;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * @author weilinhu
 */

public class PowerUtils {

    private static PowerConnectionReceiver powerConnectionReceiver;


    public static void registerPowerListener(Activity activity,PowerConnectionReceiver.PowerConnectionReceiverListener listener){
        powerConnectionReceiver = new PowerConnectionReceiver();
        powerConnectionReceiver.addListener(listener);
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        activity.registerReceiver(powerConnectionReceiver, ifilter);

    }
    public static void unRegisterPowerListener(Activity activity){


        if (powerConnectionReceiver!=null){
            activity.unregisterReceiver(powerConnectionReceiver);
            powerConnectionReceiver.removeListeners();
        }



    }

    public static int getCurrentPower(){
        return PowerConnectionReceiver.sCurrentpower;
    }

}
