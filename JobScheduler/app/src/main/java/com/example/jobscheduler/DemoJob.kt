package com.example.jobscheduler

import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.app.job.JobService
import android.widget.Toast

class DemoJob: JobService() {
    override fun onStopJob(p0: JobParameters?): Boolean {
        Toast.makeText(this,"Hello I am a scheduled job",Toast.LENGTH_SHORT).show()

        return false
    }

    override fun onStartJob(p0: JobParameters?): Boolean {

        return false
    }
}