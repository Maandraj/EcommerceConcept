package com.maandraj.explorer.presentation.adapter.category

import androidx.core.content.ContextCompat
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.maandraj.core.utils.adapter.DisplayableItem
import com.maandraj.explorer.R
import com.maandraj.explorer.databinding.ItemCategoryBinding

private var currentSelectedPosition: Int = 0

fun categoryAdapterDelegate(
    itemClickedListener: (CategoryData, positionScroll: Int) -> Unit,
) = adapterDelegateViewBinding<CategoryData,
        DisplayableItem, ItemCategoryBinding>(
    { layoutInflater, root ->
        ItemCategoryBinding.inflate(layoutInflater, root, false)

    }
) {
    with(binding) {
        btnCategory.setOnClickListener {
            this@adapterDelegateViewBinding.bindingAdapter?.notifyItemChanged(
                currentSelectedPosition)
            currentSelectedPosition = absoluteAdapterPosition
            this@adapterDelegateViewBinding.bindingAdapter?.notifyItemChanged(
                currentSelectedPosition)
            val scrollPosition: Int = absoluteAdapterPosition - 1
            itemClickedListener(item, scrollPosition)
        }
        bind {
            if (absoluteAdapterPosition == currentSelectedPosition) {
                btnCategory.setCardBackgroundColor(ContextCompat.getColorStateList(context,
                    R.color.item_category_button_select_background))
                ivCategory.imageTintList = ContextCompat.getColorStateList(context,
                    R.color.item_category_icon_select_tint)
                tvNameCategory.setTextColor(
                    ContextCompat.getColor(context, R.color.item_category_name_select_color))
            } else {
                btnCategory.setCardBackgroundColor(ContextCompat.getColorStateList(context,
                    R.color.item_category_button_unselect_background))
                ivCategory.imageTintList = ContextCompat.getColorStateList(context,
                    R.color.item_category_icon_unselect_tint)
                tvNameCategory.setTextColor(
                    ContextCompat.getColor(context, R.color.item_category_name_unselect_color))
            }
            tvNameCategory.text = getString(item.nameResId)
            ivCategory.setImageDrawable(getDrawable(item.iconResId))
        }
    }

}
