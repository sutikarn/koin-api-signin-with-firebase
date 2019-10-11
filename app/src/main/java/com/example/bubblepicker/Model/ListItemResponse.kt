package com.example.bubblepicker.Model

import android.os.Parcel
import android.os.Parcelable

data class ListItemResponse(val type: Int = 0,
                            val name: String = "") : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(type)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ListItemResponse> {
        override fun createFromParcel(parcel: Parcel): ListItemResponse {
            return ListItemResponse(parcel)
        }

        override fun newArray(size: Int): Array<ListItemResponse?> {
            return arrayOfNulls(size)
        }
    }
}


