package com.example.recyclerview.materialdialogs

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.listItems

/**
 * @author Xiaozh
 * @version
 * @data 2021/1/26
 * @email xiaozihuan994@qq.com
 * @description .
 */
class MaterialDialogManager {
    companion object {

        fun showListMaterialDialog(
                context: Context,
                arrayId: Int,
                listener: (CharSequence) -> Unit
        ) {
            MaterialDialog(context).show {
                listItems(arrayId) { _, _, text ->
                    listener(text)
                }
            }
        }

    }

}