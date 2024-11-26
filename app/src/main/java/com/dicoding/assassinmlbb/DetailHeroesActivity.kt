package com.dicoding.assassinmlbb

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailHeroesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_ROLE = "extra_role"
        const val EXTRA_URUT_HERO = "extra_urut_hero"
        const val EXTRA_TAHUN_RILIS = "extra_tahun_rilis"
        const val EXTRA_SEJARAH_SINGKAT = "extra_sejarah_singkat"
    }

    private var name: String = ""
    private var description: String = ""
    private var photo: String = ""
    private var role: String = ""
    private var urutHero: Int = 0
    private var tahunRilis: Int = 0
    private var sejarahSingkat: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_heroes)

        // Get data from intent
        intent.extras?.let { bundle ->
            name = bundle.getString(EXTRA_NAME, "")
            description = bundle.getString(EXTRA_DESCRIPTION, "")
            photo = bundle.getString(EXTRA_PHOTO, "")
            role = bundle.getString(EXTRA_ROLE, "")
            urutHero = bundle.getInt(EXTRA_URUT_HERO, 0)
            tahunRilis = bundle.getInt(EXTRA_TAHUN_RILIS, 0)
            sejarahSingkat = bundle.getString(EXTRA_SEJARAH_SINGKAT, "")
        }

        setupUI()

        val backButton = findViewById<Button>(R.id.kembali_button)
        backButton.setOnClickListener {
            finish()
        }
    }

    private fun setupUI() {
        val imgPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvRole: TextView = findViewById(R.id.tv_detail_role)
        val tvurutHero: TextView = findViewById(R.id.tv_detail_urut_hero)
        val tvtahunRilis: TextView = findViewById(R.id.tv_detail_tahun_rilis)
        val tvDescription: TextView = findViewById(R.id.tv_detail_description)
        val tvSejarahSingkat: TextView = findViewById(R.id.tv_detail_sejarah_singkat)

        Glide.with(this)
            .load(photo)
            .into(imgPhoto)

        tvName.text = name
        tvRole.text = role
        tvurutHero.text = "Urut Hero: $urutHero"
        tvtahunRilis.text = "Tahun Rilis : $tahunRilis"
        tvDescription.text = description
        tvSejarahSingkat.text = sejarahSingkat
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu resource file
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }


}