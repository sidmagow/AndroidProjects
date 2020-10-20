package com.example.workmanager.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.workmanager.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWorkMan.setOnClickListener {

            val constraint = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.METERED)
                .build()
            val workerRequest = OneTimeWorkRequestBuilder<GithubWorker>()
                .setInitialDelay(5,TimeUnit.SECONDS)
                .setConstraints(constraint)
                .build()
            WorkManager.getInstance(this)
                .enqueue(workerRequest)
        }
    }
}