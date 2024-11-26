package com.dicoding.assassinmlbb

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.assassinmlbb.databinding.ActivityMainBinding
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import android.os.Handler
import android.os.Looper


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Heroes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        splashScreen.setKeepOnScreenCondition { true }
        Handler(Looper.getMainLooper()).postDelayed({
            splashScreen.setKeepOnScreenCondition { false }
        }, 2000)


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()

    }

    private fun getListHeroes(): ArrayList<Heroes> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataRole = resources.getStringArray(R.array.data_role)
        val dataTahunRilis = resources.getIntArray(R.array.data_tahun_rilis)
        val dataurutHero = resources.getIntArray(R.array.data_urut_hero)
        val dataKisahHero = resources.getStringArray(R.array.data_kisah_hero)
        val listHeroes = ArrayList<Heroes>()
        for (i in dataName.indices) {
            val heroes = Heroes(dataName[i], dataDescription[i], dataPhoto[i], dataRole[i], dataTahunRilis[i], dataurutHero[i], dataKisahHero[i])
            listHeroes.add(heroes)
        }
        return listHeroes
    }

    private fun showRecyclerList() {
        binding.rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroesAdapter = ListHeroesAdapter(list)
        binding.rvHeroes.adapter = listHeroesAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}