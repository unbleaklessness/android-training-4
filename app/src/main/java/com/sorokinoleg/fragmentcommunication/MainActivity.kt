package com.sorokinoleg.fragmentcommunication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IMainActivity {

    companion object {
        const val TAG = "MainActivity"
    }

    private var mToolbar: Toolbar? = null
    private var mToolbarTitle: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mToolbar = toolbar
        mToolbarTitle = toolbar_title

        init()
    }

    private fun init() {
        val fragment = SelectorFragment()
        doFragmentTransaction(fragment, getString(R.string.fragment_selector), false, "")
    }

    private fun doFragmentTransaction(fragment: Fragment, tag: String, addToBackStack: Boolean, message: String) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment, tag)
        if (addToBackStack) {
            transaction.addToBackStack(tag)
        }
        transaction.commit()
    }
    override fun setToolbarTitle(title: String) {
        mToolbarTitle?.text = title
    }
}
