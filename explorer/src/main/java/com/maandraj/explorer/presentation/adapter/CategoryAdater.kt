package com.maandraj.explorer.presentation.adapter

import androidx.core.content.ContextCompat
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
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
    binding.btnCategory.setOnClickListener {
        binding.btnCategory.backgroundTintList = ContextCompat.getColorStateList(context,
            com.maandraj.core.R.color.color_main)
        this.bindingAdapter?.notifyItemChanged(currentSelectedPosition)
        currentSelectedPosition = absoluteAdapterPosition
        this.bindingAdapter?.notifyItemChanged(currentSelectedPosition)
        val scrollPosition: Int = absoluteAdapterPosition - 1
        itemClickedListener(item, scrollPosition)
    }
    bind {
        if (absoluteAdapterPosition == currentSelectedPosition) {
            binding.btnCategory.backgroundTintList = ContextCompat.getColorStateList(context,
                R.color.item_category_button_select_background)
            binding.btnCategory.iconTint = ContextCompat.getColorStateList(context,
                R.color.item_category_icon_select_tint)
            binding.tvNameCategory.setTextColor(
                ContextCompat.getColor(context, R.color.item_category_name_select_color))
        } else {
            binding.btnCategory.backgroundTintList = ContextCompat.getColorStateList(context,
                R.color.item_category_button_unselect_background)
            binding.btnCategory.iconTint = ContextCompat.getColorStateList(context,
                R.color.item_category_icon_unselect_tint)
            binding.tvNameCategory.setTextColor(
                ContextCompat.getColor(context, R.color.item_category_name_unselect_color))
        }
        binding.tvNameCategory.text = getString(item.nameResId)
        binding.btnCategory.icon = getDrawable(item.iconResId)
    }
}
