package com.sorokinoleg.fragmentcommunication

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class SelectorFragment : Fragment() {

    companion object {
        const val TAG = "SelectorFragment"
    }

    private var mIMainActivity: IMainActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mIMainActivity?.setToolbarTitle(tag.toString())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_selector, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        mIMainActivity = context as? IMainActivity
    }
}