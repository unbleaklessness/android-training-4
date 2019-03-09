package com.sorokinoleg.fragmentcommunication

interface IMainActivity {

    fun setToolbarTitle(title: String)

    fun inflateFragment(fragmentTag: String, message: String)
}