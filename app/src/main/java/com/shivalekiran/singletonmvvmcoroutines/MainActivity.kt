package com.shivalekiran.singletonmvvmcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.user.observe(this, Observer {
            println("User $it")
        })
        userViewModel.setUserId("1")
    }

    override fun onDestroy() {
        super.onDestroy()
        userViewModel.cancelJob()
    }
}
