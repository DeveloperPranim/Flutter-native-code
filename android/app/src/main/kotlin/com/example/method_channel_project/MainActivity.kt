package com.example.method_channel_project





import android.app.admin.DevicePolicyManager
import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel


class MainActivity: FlutterActivity() {
    private val CHANNEL = "toggle_screen"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
                call, result ->
            if (call.method.equals("getScreenState")) {

                // Toggle the screen off
             
             lock();
            } else {
                result.notImplemented();
            }
        }
    }

    private fun lock() {
        val mDPM = getSystemService(DEVICE_POLICY_SERVICE) as DevicePolicyManager
        mDPM.lockNow()
}}



