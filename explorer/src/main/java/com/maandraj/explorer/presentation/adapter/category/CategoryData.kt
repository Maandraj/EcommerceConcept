package com.maandraj.explorer.presentation.adapter.category

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.maandraj.explorer.R
import com.maandraj.core.utils.adapter.DisplayableItem

data class CategoryData(
    @DrawableRes
    val iconResId: Int,
    @StringRes
    val nameResId: Int,
) : DisplayableItem {
    companion object {
        fun createListExample() : List<CategoryData> = listOf(
            CategoryData(iconResId = R.drawable.ic_item_phone, R.string.item_phone_name),
            CategoryData(iconResId = R.drawable.ic_item_pc,  R.string.item_pc_name),
            CategoryData(iconResId = R.drawable.ic_item_health,  R.string.item_health_name),
            CategoryData(iconResId = R.drawable.ic_item_books,  R.string.item_books_name),
            CategoryData(iconResId = R.drawable.ic_item_tools,  R.string.item_tools_name),
        )
    }
}
