package com.sorokinoleg.fragmentcommunication

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class SelectorFragment : Fragment(), View.OnClickListener {

    companion object {
        const val TAG = "SelectorFragment"
    }

    private var iMainActivity: IMainActivity? = null

    private var buttonFragmentA: Button? = null
    private var buttonFragmentB: Button? = null
    private var buttonFragmentC: Button? = null
    private var message: EditText? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        iMainActivity = context as? IMainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        iMainActivity?.setToolbarTitle(getString(R.string.fragment_selector))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_selector, container, false)

        buttonFragmentA = view.findViewById(R.id.button_fragment_a)
        buttonFragmentB = view.findViewById(R.id.button_fragment_b)
        buttonFragmentC = view.findViewById(R.id.button_fragment_c)
        message = view.findViewById(R.id.message)

        buttonFragmentA?.setOnClickListener(this)
        buttonFragmentB?.setOnClickListener(this)
        buttonFragmentC?.setOnClickListener(this)

        return view
    }

    override fun onClick(view: View?) {
        val message = message?.text.toString()

        when (view) {
            buttonFragmentA ->
                iMainActivity?.inflateFragment(AFragment.TAG, message)
            buttonFragmentB ->
                iMainActivity?.inflateFragment(BFragment.TAG, message)
            buttonFragmentC ->
                iMainActivity?.inflateFragment(CFragment.TAG, message)
        }
    }
}