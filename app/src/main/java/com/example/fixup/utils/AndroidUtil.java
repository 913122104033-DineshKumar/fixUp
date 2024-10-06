package com.example.fixup.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.Timer;
import java.util.TimerTask;

public class AndroidUtil {
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    public static void switchActivity(Context src, Class<?> dst) {
        Intent intent = new Intent(src, dst);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        src.startActivity(intent);
    }
    public static void showDialog(Context context, String title, String message, String positive,
                                  String negative, Runnable positiveMethod, Runnable negativeMethod) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positive, ((dialog, which) -> {
                    if (positiveMethod != null) {
                        positiveMethod.run();
                    }
                }))
                .setNegativeButton(negative, ((dialog, which) -> {
                    if (negativeMethod != null) {
                        negativeMethod.run();
                    }
                }));
        builder.create().show();
    }
}
