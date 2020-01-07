package com.sample.koin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sample.koin.data.repository.LoginRepository
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    // Inject Dependency
    private val loginRepository: LoginRepository by inject()

    private val apiKey: String by inject(qualifier = named("API_KEY"))

    private val staticToken: String = get(qualifier = named("STATIC_TOKEN"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Login Repository 1 = $loginRepository")

        Log.d(TAG, "API_KEY = $apiKey")

        Log.d(TAG, "STATIC_TOKEN = $staticToken")
    }
}
