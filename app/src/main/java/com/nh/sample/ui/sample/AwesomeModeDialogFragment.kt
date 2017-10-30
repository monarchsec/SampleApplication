package com.nh.sample.ui.sample

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nh.sample.R

/**
 *
 * <br/><br/>
 * Created by nick.hanna on 10/29/17.
 */
class AwesomeModeDialogFragment: DialogFragment() {
    companion object {
        val TAG: String = AwesomeModeDialogFragment::javaClass.name
        fun newInstance(): AwesomeModeDialogFragment {
            return AwesomeModeDialogFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.awesome_mode_dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}