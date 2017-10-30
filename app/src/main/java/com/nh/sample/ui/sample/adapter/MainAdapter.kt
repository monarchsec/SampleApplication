package com.nh.sample.ui.sample.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.TranslateAnimation
import android.widget.CompoundButton
import com.nh.sample.R
import com.nh.sample.data.item.MainItem
import kotlinx.android.synthetic.main.main_item.view.*
import kotlinx.android.synthetic.main.main_item_one.view.*
import kotlinx.android.synthetic.main.radio_group_row.view.*
import kotlinx.android.synthetic.main.switch_row.view.*
import java.util.*



/**
 *
 * <br/><br/>
 * Created by nick.hanna on 10/28/17.
 */
class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    val mData: MutableList<MainItem> = LinkedList()
    var mContext: Context? = null
    var mLastPosition: Int = -1
    var mParentView: View? = null
    var mListener: CompoundButton.OnCheckedChangeListener? = null

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindItem(mData[position])
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 500

        holder?.itemView?.startAnimation(anim)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        mContext = parent?.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.main_item_one, parent, false)
        return ViewHolder(view)
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder?) {
        holder?.clearAnim()
        super.onViewDetachedFromWindow(holder)
    }


    class ViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        fun bindItem(item: MainItem) {
            with(item) {
                itemView.background.setColorFilter(Color.parseColor(item.mColor), PorterDuff.Mode.SRC_OVER)
                itemView.item_title.text = item.mTitle
                itemView.item_radio_group.label.text = item.mRadioTitle
                itemView.item_radio_group.radio_button1.text = item.mRadioItems?.get(0)
                itemView.item_radio_group.radio_button2.text = item.mRadioItems?.get(1)
                itemView.item_radio_group.radio_button3.text = item.mRadioItems?.get(2)
                itemView.item_switch.switch_label.text = item.mSwitchItemTitle
                itemView.item_switch.switch_row_switch.text = item.mSwitchText

            }
        }

        fun clearAnim() {
            itemView?.main_item_root?.clearAnimation()
        }
    }

    private fun setAnim(viewToAnimate: View, position: Int) {
        if(position > mLastPosition) {
//            val alphaAnim: AlphaAnimation = AlphaAnimation(1.0f, 0.0f)
            val transAnim: TranslateAnimation = TranslateAnimation(viewToAnimate.x, viewToAnimate.x-500, viewToAnimate.y, viewToAnimate.y)
            transAnim.duration = 500
            viewToAnimate.startAnimation(transAnim)
            // anim: Animation = ...load animation
            // viewToAnimate.startAnimation(anim)
            mLastPosition = position
        }
    }
}