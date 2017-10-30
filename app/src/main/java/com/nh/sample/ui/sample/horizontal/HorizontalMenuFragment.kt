package com.nh.sample.ui.sample.horizontal

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nh.sample.R
import com.nh.sample.data.item.HorizontalMenuItem
import com.nh.sample.ui.sample.adapter.HorizontalAdapter
import kotlinx.android.synthetic.main.horizontal_menu_fragment.*

/**
 *
 * <br/><br/>
 * Created by nick.hanna on 10/29/17.
 */
class HorizontalMenuFragment: Fragment() {
    companion object {
        @JvmField val TAG: String = HorizontalMenuFragment::javaClass.name
        @JvmStatic fun newInstance(): HorizontalMenuFragment {
            return HorizontalMenuFragment()
        }
    }

    var mAdapter: HorizontalAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.horizontal_menu_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = HorizontalAdapter()
        var item1: HorizontalMenuItem = HorizontalMenuItem("No", "Auto", "Yes", "Enable Cool Features",
                "", "Enable Awesome Mode", "Awesome Mode Settings")
        var item2: HorizontalMenuItem = HorizontalMenuItem("No", "Auto", "Yes", "Enable Cool Features",
                "", "Enable Awesome Mode", "Awesome Mode Settings")
        mAdapter?.mData?.add(item1)
        mAdapter?.mData?.add(item2)

        horizontal_menu_frag_recycler.adapter = mAdapter
        var man: LinearLayoutManager = LinearLayoutManager(activity.applicationContext)
        man.orientation = LinearLayoutManager.HORIZONTAL
        horizontal_menu_frag_recycler.layoutManager = man
    }
}