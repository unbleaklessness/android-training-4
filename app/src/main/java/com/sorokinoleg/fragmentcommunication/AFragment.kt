package com.sorokinoleg.fragmentcommunication

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AFragment : Fragment() {

    companion object {
        const val TAG = "AFragment"
    }

    private var mIMainActivity: IMainActivity? = null

    private var mIncomingMessage: TextView? = null

    private var incomingMessageString: String? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        mIMainActivity = context as? IMainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mIMainActivity?.setToolbarTitle(tag.toString())

        incomingMessageString = arguments?.getString(getString(R.string.intent_message))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        mIncomingMessage = view.findViewById(R.id.incoming_message)

        setIncomingMessage()

        return view
    }

    private fun setIncomingMessage() {
        incomingMessageString?.let {
            mIncomingMessage?.text = incomingMessageString
        }
    }
}