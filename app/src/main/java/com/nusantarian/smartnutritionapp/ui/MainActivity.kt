package com.nusantarian.smartnutritionapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.nusantarian.smartnutritionapp.R
import com.nusantarian.smartnutritionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.addOnBackStackChangedListener(this)
        initMainFragment()
    }

    private fun initMainFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.frame_main, HomeFragment())
            .commit()
    }

    override fun onBackStackChanged() {

    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStack()
        else
            super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.popBackStack()
        return true
    }
}