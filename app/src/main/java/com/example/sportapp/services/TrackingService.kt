package com.example.sportapp.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Build.VERSION_CODES.O
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import com.example.sportapp.R
import com.example.sportapp.ui.activity.main.MainActivity
import com.example.sportapp.util.Constant.ACTION_PAUSE
import com.example.sportapp.util.Constant.ACTION_SHOW_TRACKING_FRAGMENT
import com.example.sportapp.util.Constant.ACTION_START_OR_RESUME
import com.example.sportapp.util.Constant.ACTION_STOP
import com.example.sportapp.util.Constant.NOTIFCATION_NAME
import com.example.sportapp.util.Constant.NOTIFCATOPN_ID
import timber.log.Timber

class TrackingService : LifecycleService() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
        if (intent != null) {
            when (intent.action) {
                ACTION_START_OR_RESUME -> {
                    Timber.d("ACTION_START_OR_RESUME Service")
                }
                ACTION_PAUSE -> {
                    Timber.d("ACTION_PAUSE Service")
                }
                ACTION_STOP -> {

                    Timber.d("ACTION_STOP Service")
                }
            }
        }
    }

    fun getMainActivtyPendingIntent() = PendingIntent.getActivity(
        this, 0,
        Intent(this, MainActivity::class.java).also {
            it.action = ACTION_SHOW_TRACKING_FRAGMENT
        }, FLAG_UPDATE_CURRENT
    )

    fun startForegroundService() {
        var manger = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT > O) {
            createNotifcationService(manger)
        }
        NotificationCompat.Builder(this, NOTIFCATOPN_ID).setAutoCancel(false)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_run)
            .setContentTitle(R.string.app_name.toString())
            .setContentText("")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotifcationService(manger: NotificationManager) {
        var channel = NotificationChannel(NOTIFCATOPN_ID, NOTIFCATION_NAME, IMPORTANCE_LOW)
        manger.createNotificationChannel(channel)

    }
}