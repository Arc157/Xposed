package com.arc.xposed;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        XposedHelpers.findAndHookMethod(Activity.class, "onCreate", Bundle.class, new XC_MethodReplacement() {

            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                Toast.makeText(MainApplication.this, "Hooked!", Toast.LENGTH_LONG).show();
                return XposedBridge.invokeOriginalMethod(param.method, param.thisObject, param.args);
            }
        });
    }
}
