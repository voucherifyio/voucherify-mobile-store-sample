package io.voucherify.android.sample.store.ui.onboarding

import android.animation.ArgbEvaluator
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.base.BaseActivity
import io.voucherify.android.sample.store.ui.flow.Navigator
import io.voucherify.android.sample.store.utils.views.DrawableUtils
import kotlinx.android.synthetic.main.activity_onboarding.*
import kotlinx.android.synthetic.main.fragment_onboarding_page.view.*
import javax.inject.Inject

class OnboardingActivity : BaseActivity() {

    companion object Factory {
        @JvmStatic
        fun createIntent(context: Context) = Intent(context, OnboardingActivity::class.java)
    }

    @Inject
    lateinit var viewModel: OnboardingViewModel

    @Inject
    lateinit var navigator: Navigator

    private var sectionsPagerAdapter: SectionsPagerAdapter? = null
    private var indicators: Array<ImageView> = emptyArray()
    private var page = 0

    private val dataObserver = Observer<Boolean> { hasActiveOnboarding ->

        if (hasActiveOnboarding.not()) {
            navigator.openSplashActivity(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.statusBarColor = ContextCompat.getColor(this, R.color.voucherify_black_80)
        }

        setContentView(R.layout.activity_onboarding)

        setBindings()

        sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP)
            ContextCompat.getDrawable(this, R.drawable.ic_chevron_right_24px)?.let {
                onboarding_next_button.setImageDrawable(
                    DrawableUtils.tintMyDrawable(it, Color.WHITE)
                )
            }

        indicators = arrayOf(
            onboarding_indicator_0,
            onboarding_indicator_1,
            onboarding_indicator_2
        )

        onboarding_pager.adapter = sectionsPagerAdapter

        onboarding_pager.currentItem = page
        updateIndicators(page)

        val color1 = ContextCompat.getColor(this, R.color.voucherify_blue)
        val color2 = ContextCompat.getColor(this, R.color.voucherify_green_dark)
        val color3 = ContextCompat.getColor(this, R.color.voucherify_grey_dark)

        val colorList = intArrayOf(color1, color2, color3)

        val evaluator = ArgbEvaluator()

        onboarding_pager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                val colorUpdate = evaluator.evaluate(
                    positionOffset,
                    colorList[position],
                    colorList[if (position == 2) position else position + 1]
                ) as Int

                onboarding_pager.setBackgroundColor(colorUpdate)
            }

            override fun onPageSelected(position: Int) {

                page = position

                updateIndicators(page)

                when (position) {
                    0 -> onboarding_pager.setBackgroundColor(color1)
                    1 -> onboarding_pager.setBackgroundColor(color2)
                    2 -> onboarding_pager.setBackgroundColor(color3)
                }

                onboarding_next_button.visibility = if (position == 2) View.GONE else View.VISIBLE
                onboarding_finish_button.visibility = if (position == 2) View.VISIBLE else View.GONE
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        onboarding_next_button.setOnClickListener {
            page += 1
            onboarding_pager.setCurrentItem(page, true)
        }

        onboarding_skip_button.setOnClickListener {
            viewModel.setOnboardingAsShown()
        }

        onboarding_finish_button.setOnClickListener {
            viewModel.setOnboardingAsShown()
        }
    }

    fun setBindings() {

        viewModel
            .outputOnboardingActiveUpdate()
            .observe(this, dataObserver)
    }

    fun updateIndicators(position: Int) {
        for (i in indicators.indices) {
            indicators[i].setBackgroundResource(
                if (i == position) R.drawable.indicator_selected else R.drawable.indicator_unselected
            )
        }
    }

    class PlaceholderFragment : Fragment() {

        internal var bgs = intArrayOf(
            io.voucherify.android.sample.store.R.drawable.ic_avatar_circle_24px,
            io.voucherify.android.sample.store.R.drawable.ic_avatar_circle_24px,
            io.voucherify.android.sample.store.R.drawable.ic_avatar_circle_24px
        )

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val rootView =
                inflater.inflate(R.layout.fragment_onboarding_page, container, false)

            rootView.onboarding_section_headline.text = arguments?.getInt(ARG_SECTION_NUMBER).toString()
            rootView.onboarding_section_image.setBackgroundResource(bgs[arguments!!.getInt(ARG_SECTION_NUMBER) - 1])

            return rootView
        }

        companion object {

            private val ARG_SECTION_NUMBER = "section_number"

            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }

    class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return PlaceholderFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "SECTION 1"
                1 -> return "SECTION 2"
                2 -> return "SECTION 3"
            }

            return null
        }
    }
}