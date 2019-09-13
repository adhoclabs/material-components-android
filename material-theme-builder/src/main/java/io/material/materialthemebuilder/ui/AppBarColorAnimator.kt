package io.material.materialthemebuilder.ui

import android.view.View
import android.view.Window
import androidx.annotation.ColorInt
import androidx.viewpager.widget.ViewPager
import com.google.android.material.animation.ArgbEvaluatorCompat
import com.google.android.material.tabs.TabLayout

class AppBarColorAnimator(
  @ColorInt private val primaryColorsByPosition: IntArray,
  @ColorInt private val accentColorsByPosition: IntArray,
  private val view: View,
  private val tabLayout: TabLayout,
  private val window: Window
): ViewPager.OnPageChangeListener {
  override fun onPageScrollStateChanged(state: Int) { }

  override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    if (position < primaryColorsByPosition.size - 1 && position < primaryColorsByPosition.size - 1) {
      ArgbEvaluatorCompat
        .getInstance()
        .evaluate(positionOffset, primaryColorsByPosition[position], primaryColorsByPosition[position + 1])
        .let {
          view.setBackgroundColor(it)
          window.statusBarColor = it
        }

      ArgbEvaluatorCompat
        .getInstance()
        .evaluate(positionOffset, accentColorsByPosition[position], accentColorsByPosition[position + 1])
        .let {
          tabLayout.setSelectedTabIndicatorColor(it)
        }
    } else {
      primaryColorsByPosition.last().let {
        view.setBackgroundColor(it)
        window.statusBarColor = it
      }

      accentColorsByPosition.last().let {
        tabLayout.setSelectedTabIndicatorColor(it)
      }
    }
  }

  override fun onPageSelected(position: Int) { }

}
