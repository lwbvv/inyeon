package com.example.inyeon

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class ActivityMain: AppCompatActivity() {

    private val mFragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportFragmentManager.beginTransaction().replace(R.id.mainFragment,FragmentHome()).commit()
        mFragmentManager.beginTransaction().add(R.id.mainFragment, FragmentHome()).commit()

        mainToHomeButton.setOnClickListener {
            var fragmentTransaction = mFragmentManager.beginTransaction();
            val getTopFragment = supportFragmentManager.findFragmentById(R.id.mainFragment)
            when(getTopFragment){
                is FragmentHome -> return@setOnClickListener
                else -> fragmentTransaction.replace(R.id.mainFragment, FragmentHome()).commit()
            }
        }

        mainToAssessmentButton.setOnClickListener {
            var fragmentTransaction = mFragmentManager.beginTransaction()
            val getTopFragment = supportFragmentManager.findFragmentById(R.id.mainFragment)
            when(getTopFragment){

                is FragmentAssessment -> return@setOnClickListener
                else -> fragmentTransaction.replace(R.id.mainFragment, FragmentAssessment()).commit()
            }
        }

        mainToFavoriteButton.setOnClickListener {
            var fragmentTransaction = mFragmentManager.beginTransaction()
            val getTopFragment = supportFragmentManager.findFragmentById(R.id.mainFragment)
            when(getTopFragment){
                is FragmentFavorite -> return@setOnClickListener
                else -> fragmentTransaction.replace(R.id.mainFragment, FragmentFavorite()).commit()
            }
        }

        mainToMessageButton.setOnClickListener {
            var fragmentTransaction = mFragmentManager.beginTransaction()
            val getTopFragment = supportFragmentManager.findFragmentById(R.id.mainFragment)
            when(getTopFragment){
                is FragmentMessage -> return@setOnClickListener
                else -> fragmentTransaction.replace(R.id.mainFragment, FragmentMessage()).commit()
            }
        }
        mainToStoreButton.setOnClickListener {
            var fragmentTransaction = mFragmentManager.beginTransaction()
            val getTopFragment = supportFragmentManager.findFragmentById(R.id.mainFragment)
            when(getTopFragment){
                is FragmentStore -> return@setOnClickListener
                else -> fragmentTransaction.replace(R.id.mainFragment, FragmentStore()).commit()
            }
        }
    }


}