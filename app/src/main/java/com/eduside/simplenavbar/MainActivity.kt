package com.eduside.simplenavbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.eduside.simplenavbar.databinding.ActivityMainBinding
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


        addFragment(ProfileFragment())
        bottom_navigation.show(0)
        bottom_navigation.add(MeowBottomNavigation.Model(0,R.drawable.ic_profile))
        bottom_navigation.add(MeowBottomNavigation.Model(1,R.drawable.ic_game))

        onClick()
    }

    private fun onClick() {

        mainBinding.bottomNavigation.setOnClickMenuListener {
            when(it.id){
                0 -> {
                    Toast.makeText(this, "PROFILE", Toast.LENGTH_SHORT).show()
                    //  replaceFragment(HomeFragment.newInstance(),true)

                    val fragmenprofile =  ProfileFragment()
                    val fragment : Fragment? =  supportFragmentManager.findFragmentByTag(ProfileFragment::class.java.simpleName)

                    if (fragment !is ProfileFragment){
                        supportFragmentManager.beginTransaction()
                            .add(R.id.fragmentContainer, fragmenprofile, ProfileFragment::class.java.simpleName)
                            .commit()
                    }


                }

                1 -> {
                    Toast.makeText(this, "GAME", Toast.LENGTH_SHORT).show()
                    //replaceFragment(HomeFragment.newInstance(),true)
                    val fragments =  HomeFragment()
                    val fragment : Fragment? =  supportFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

                    if (fragment !is HomeFragment){
                        supportFragmentManager.beginTransaction()
                            .add(R.id.fragmentContainer, fragments, ProfileFragment::class.java.simpleName)
                            .commit()
                    }

                }

                else -> {
                    Toast.makeText(this, "GAME", Toast.LENGTH_SHORT).show()
                    //replaceFragment(HomeFragment.newInstance(),true)
                    val fragments =  HomeFragment()
                    val fragment : Fragment? =  supportFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

                    if (fragment !is HomeFragment){
                        supportFragmentManager.beginTransaction()
                            .add(R.id.fragmentContainer, fragments, ProfileFragment::class.java.simpleName)
                            .commit()
                    }

                }
            }
        }




    }


    private fun addFragment(fragment:Fragment){
        val fragmentransisi =  supportFragmentManager.beginTransaction()
        fragmentransisi.add(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()

    }

}




