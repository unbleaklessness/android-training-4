package com.sorokinoleg.fragmentcommunication

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_selector.view.*

class SelectorFragment : Fragment(), View.OnClickListener {

    companion object {
        const val TAG = "SelectorFragment"
    }

    private var mIMainActivity: IMainActivity? = null

    private var mButtonFragmentA: Button? = null
    private var mButtonFragmentB: Button? = null
    private var mButtonFragmentC: Button? = null
    private var mMessage: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mIMainActivity?.setToolbarTitle(tag.toString())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_selector, container, false)

        mButtonFragmentA = view.findViewById(R.id.button_fragment_a)
        mButtonFragmentB = view.findViewById(R.id.button_fragment_b)
        mButtonFragmentC = view.findViewById(R.id.button_fragment_c)
        mMessage = view.findViewById(R.id.message)

        mButtonFragmentA?.setOnClickListener(this)
        mButtonFragmentB?.setOnClickListener(this)
        mButtonFragmentC?.setOnClickListener(this)

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        mIMainActivity = context as? IMainActivity
    }

    override fun onClick(view: View?) {
        val message = mMessage?.text?.toString()

        when (view?.id) {
            R.id.button_fragment_a ->
                mIMainActivity?.inflateFragment(getString(R.string.fragment_a), message.toString())
            R.id.button_fragment_b ->
                mIMainActivity?.inflateFragment(getString(R.string.fragment_b), message.toString())
            R.id.button_fragment_c ->
                mIMainActivity?.inflateFragment(getString(R.string.fragment_c), message.toString())
        }
    }
}