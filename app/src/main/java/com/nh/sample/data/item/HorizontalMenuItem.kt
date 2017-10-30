package com.nh.sample.data.item

/**
 *
 * <br/><br/>
 * Created by nick.hanna on 10/29/17.
 */
class HorizontalMenuItem(radItem1: String, radItem2: String, radItem3: String,
                         radTitle: String, switchText : String, switchTitle: String,
                         title: String) {

    var mRadioTitle: String? = null
    var mSwitchText: String? = null
    var mSwitchItemTitle: String? = null
    var mRadioItems: Array<String>? = null
    var mTitle: String? = null

    init {
        mRadioItems = arrayOf(radItem1, radItem2, radItem3)
        mRadioTitle = radTitle
        mSwitchItemTitle = switchTitle
        mSwitchText = switchText
        mTitle = title
    }

}