package com.nh.sample.ui.sample


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nh.sample.R
import com.nh.sample.data.item.MainItem
import com.nh.sample.ui.sample.adapter.MainAdapter
import com.nh.sample.util.TextGenerator
import kotlinx.android.synthetic.main.main_fragment.*

/**
 *
 * <br/><br/>
 * Created by nick.hanna on 10/28/17.
 */
class MainFragment : Fragment() {
    companion object {
        @JvmField val TAG = MainFragment::javaClass.name
        @JvmStatic fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    var mAdapter: MainAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View? = inflater?.inflate(R.layout.main_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = MainAdapter()
        val item1: MainItem = MainItem("No", "Auto", "Yes", "Enable Cool Features",
                "", "Enable Awesome Mode", "Awesome Mode Settings")
        val item2: MainItem = MainItem("No", "Auto", "Yes", "Enable Cool Features",
                "", "Enable Awesome Mode", "Awesome Mode Settings")
        val item3: MainItem = MainItem("What?", "OK", "Not OK", "Authorization Please",
                "", "Enable strict", "Secure Mode")
        item1.mColor = "#ffff4444"
        item2.mColor = "#1565c0"
        item3.mColor = "#ff5722"

        val generator: TextGenerator = TextGenerator()
        val colors: Array<String?> = arrayOf(item1.mColor, item2.mColor, item3.mColor)
        mAdapter?.mParentView = main_frag_root
        mAdapter?.mData?.add(item1)
        mAdapter?.mData?.add(item2)
        mAdapter?.mData?.add(item3)
        for(i in 1..10) {
            /* 12 words to 'fill up' a MainItem */
            val words: List<String> = generator.getWords(12)
            val item: MainItem = MainItem(words[6], words[7], words[8],
                    words[3]+" "+words[4]+" "+words[5], "",
                    words[9]+" "+words[10]+" "+words[11], words[0]+" "+words[1]+" "+words[2])
            item.mColor = colors[i % 3]
            mAdapter?.mData?.add(item)
        }

        val man = LinearLayoutManager(activity.applicationContext)
        man.orientation = LinearLayoutManager.VERTICAL

        main_frag_recycler.layoutManager = man
        main_frag_recycler.adapter = mAdapter
        AwesomeModeDialogFragment.newInstance().show(fragmentManager, AwesomeModeDialogFragment.TAG)
    }
}