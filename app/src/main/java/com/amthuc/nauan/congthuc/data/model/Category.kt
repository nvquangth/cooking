package com.amthuc.nauan.congthuc.data.model

import android.os.Parcel
import android.os.Parcelable

/**
 *   Created by quangnv on 25/01/2019
 */

data class Category(
    var title: String? = null,
    var source: String? = null,
    var images: List<String>? = null,
    var recipes: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        source = parcel.readString()
        images = parcel.createStringArrayList()
        recipes = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(source)
        parcel.writeStringList(images)
        parcel.writeInt(recipes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Category> {
        override fun createFromParcel(parcel: Parcel): Category {
            return Category(parcel)
        }

        override fun newArray(size: Int): Array<Category?> {
            return arrayOfNulls(size)
        }
    }
}