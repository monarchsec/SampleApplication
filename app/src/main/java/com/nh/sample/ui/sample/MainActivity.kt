package com.nh.sample.ui.sample

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import butterknife.BindView
import butterknife.ButterKnife
import com.nh.sample.R

class MainActivity : AppCompatActivity() {

    @JvmField @BindView(R.id.main_drawer_layout)
    var mDrawerLayout: DrawerLayout? = null

    @JvmField @BindView(R.id.toolbar)
    var mToolbar: Toolbar? = null

    @JvmField @BindView(R.id.main_nav_view)
    var mNavView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        setSupportActionBar(mToolbar)
        setupDrawerContent(mNavView)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val toggle = ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open_drawer, R.string.close_drawer)
        toggle.syncState()
        mDrawerLayout?.addDrawerListener(toggle)

        val frag = MainFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_content_frame, frag, MainFragment.TAG)
        transaction.commit()
    }

    private fun setupDrawerContent(navigationView: NavigationView?) {
        navigationView?.setNavigationItemSelectedListener { menuItem ->
            selectDrawerItem(menuItem)
            true
        }
    }

    private fun selectDrawerItem(item: MenuItem) {
        when (item.itemId) {
            R.id.nav_menu_settings -> Log.e("Sample", "settings")
            R.id.nav_menu_home -> {
            }
            R.id.nav_menu_activity -> Log.e("Sample", "activity")
            R.id.nav_menu_sign_out -> {
            }
            R.id.nav_menu_users -> Log.e("Sample", "users")
            else -> {
            }
        }
        mDrawerLayout?.closeDrawers()
    }
}
