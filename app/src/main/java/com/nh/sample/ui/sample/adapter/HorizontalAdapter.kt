package com.nh.sample.ui.sample.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nh.sample.R
import com.nh.sample.data.item.HorizontalMenuItem
import kotlinx.android.synthetic.main.hor_item_one.view.*
import kotlinx.android.synthetic.main.radio_group_row.view.*
import kotlinx.android.synthetic.main.switch_row.view.*
import java.util.*

/**
 *
 * <br/><br/>
 * Created by nick.hanna on 10/29/17.
 */
class HorizontalAdapter: RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {

    var mData: MutableList<HorizontalMenuItem> = LinkedList()

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var v: View? = LayoutInflater.from(parent?.context).inflate(R.layout.hor_item_one, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindData(mData[position])
    }

    class ViewHolder: RecyclerView.ViewHolder {
        constructor(itemView: View?) : super(itemView)

        fun bindData(item: HorizontalMenuItem) {
            with(item) {
                itemView.item_title.text = item.mTitle
                itemView.item_radio_group.label.text = item.mRadioTitle
                itemView.item_radio_group.radio_button1.text = item.mRadioItems?.get(0)
                itemView.item_radio_group.radio_button2.text = item.mRadioItems?.get(1)
                itemView.item_radio_group.radio_button3.text = item.mRadioItems?.get(2)
                itemView.item_switch.switch_label.text = item.mSwitchItemTitle
                itemView.item_switch.switch_row_switch.text = item.mSwitchText
            }
        }
    }
}