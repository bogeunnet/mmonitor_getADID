package com.example.adid_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class MainActivity : AppCompatActivity() {

    private val tag = "Bogeun"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Log.d(tag, "나온다")

        GlobalScope.launch {
            try {
                val info = AdvertisingIdClient.getAdvertisingIdInfo(this@MainActivity)
                if (!info.isLimitAdTrackingEnabled) {
                    Log.d(tag, "AdId: ${info.id}")
                } else {
                    Log.d(tag, "isLimitAdTrackingEnabled: true")
                }
            } catch (e: GooglePlayServicesNotAvailableException) {
                Log.d(tag, e.message.toString())
            } catch (e: GooglePlayServicesRepairableException) {
                Log.d(tag, e.message.toString())
            }
        }
    }

}