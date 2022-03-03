package com.example.sportapp.util

import android.Manifest
import android.content.Context
import android.os.Build
import android.os.Build.VERSION_CODES.Q
import pub.devrel.easypermissions.EasyPermissions

object PermissinUtils {
    fun checkPermission(context: Context): Boolean {

        if (Build.VERSION.SDK_INT > Q) {
            return EasyPermissions.hasPermissions(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        } else {

            return EasyPermissions.hasPermissions(
                context, Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )

        }
    }
}

