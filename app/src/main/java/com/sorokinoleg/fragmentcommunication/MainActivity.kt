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

        mToolbar = findViewById(R.id.toolbar)
        mToolbarTitle = findViewById(R.id.toolbar_title)

        init()
    }

    private fun init() {
        val fragment = SelectorFragment()
        doFragmentTransaction(fragment, getString(R.string.fragment_selector), false, "")
    }

    private fun doFragmentTransaction(fragment: Fragment, tag: String, addToBackStack: Boolean, message: String) {
        val transaction = supportFragmentManager.beginTransaction()

        if (message != "") {
            val bundle = Bundle()
            bundle.putString(getString(R.string.intent_message), message)
            fragment.arguments = bundle
        }

        transaction.replace(R.id.main_container, fragment, tag)

        if (addToBackStack) {
            transaction.addToBackStack(tag)
        }

        transaction.commit()
    }

    override fun setToolbarTitle(title: String) {
        mToolbarTitle?.text = title
    }

    override fun inflateFragment(fragmentTag: String, message: String) {
        when (fragmentTag) {
            getString(R.string.fragment_a) -> doFragmentTransaction(AFragment(), fragmentTag, true, message)
            getString(R.string.fragment_b) -> doFragmentTransaction(BFragment(), fragmentTag, true, message)
            getString(R.string.fragment_c) -> doFragmentTransaction(CFragment(), fragmentTag, true, message)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        mToolbarTitle?.text = getString(R.string.fragment_selector)
    }
}
