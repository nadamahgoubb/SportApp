package com.example.sportapp.ui.fragment

import android.os.Build
import android.os.Build.VERSION_CODES.Q
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportapp.R
import com.example.sportapp.util.Constant.LOCATION_PERMISSION
import com.example.sportapp.util.PermissinUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_run.*
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

@AndroidEntryPoint

class RunFragment : Fragment(R.layout.fragment_run), EasyPermissions.PermissionCallbacks {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener {
            findNavController().navigate(R.id.action_RunFragment_to_TrackingFragment)
        }
        requestLocationPermisson()
    }

    fun requestLocationPermisson() {
        if (PermissinUtils.checkPermission(requireContext())) {
            return
        }
        if (Build.VERSION.SDK_INT > Q) {
            EasyPermissions.requestPermissions(
                this, "please allow location acess to use this app", LOCATION_PERMISSION,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )

        }
        if (Build.VERSION.SDK_INT > Q) {
            EasyPermissions.requestPermissions(
                this, "please allow location acess to use this app", LOCATION_PERMISSION,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        } else {
            requestLocationPermisson()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }
}