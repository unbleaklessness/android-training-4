package com.sorokinoleg.fragmentcommunication

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CFragment : Fragment() {

    companion object {
        const val TAG = "CFragment"
    }

    private var iMainActivity: IMainActivity? = null

    private var incomingMessage: TextView? = null

    private var intentMessage: String? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        iMainActivity = context as? IMainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        iMainActivity?.setToolbarTitle(getString(R.string.fragment_c))

        intentMessage = arguments?.getString(getString(R.string.intent_message))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_c, container, false)

        incomingMessage = view.findViewById(R.id.incoming_message)

        setIncomingMessage()

        return view
    }

    private fun setIncomingMessage() {
        intentMessage?.let {
            incomingMessage?.text = intentMessage
        }
    }
}