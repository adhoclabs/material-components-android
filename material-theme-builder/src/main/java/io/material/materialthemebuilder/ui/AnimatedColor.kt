package io.material.materialthemebuilder.ui

import androidx.annotation.ColorInt
import com.google.android.material.animation.ArgbEvaluatorCompat

object AnimatedColor {

  @ColorInt
  fun with(delta: Float, @ColorInt startColor: Int, @ColorInt endColor: Int): Int {
    if (delta <= 0) return startColor
    return if (delta >= 1) endColor
    else ArgbEvaluatorCompat.getInstance().evaluate(delta, startColor, endColor)
  }
}
