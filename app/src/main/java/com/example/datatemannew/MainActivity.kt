package com.example.datatemannew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.example.datatemannew.databinding.ActivityMainBinding
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var auth:FirebaseAuth? = null
    private val RC_SIGN_IN = 1
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //inisiasi ID(button)
        binding.logout.setOnClickListener(this)
        binding.save.setOnClickListener(this)
        binding.showData.setOnClickListener(this)

        //mendapatkan Instance Firebase Autentikasi
        auth = FirebaseAuth.getInstance()
    }

    private  fun isEmpty(s:String): Boolean {
        return TextUtils.isEmpty(s)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.save -> {}
            R.id.logout -> {
                AuthUI.getInstance().signOut(this)
                    .addOnCompleteListener(object : OnCompleteListener<Void> {
                        override fun onComplete(p0: Task<Void>) {
                            Toast.makeText(this@MainActivity, "Logout Berhasil",
                                Toast.LENGTH_LONG).show()
                            intent = Intent(applicationContext, LoginActivityNew::class.java)
                            startActivity(intent)
                            finish()
                        }
                    })
            }
            R.id.show_data -> {}
        }
    }

}