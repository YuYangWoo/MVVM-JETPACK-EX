package com.example.coordinatorlayout

import android.content.res.Resources

fun Int.toDp(): Int {
    return (this * Resources.getSystem().displayMetrics.density + 0.5F).toInt()
}
