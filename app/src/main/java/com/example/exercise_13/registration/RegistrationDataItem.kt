package com.example.exercise_13.registration

import com.google.gson.annotations.SerializedName

data class RegistrationDataItem(
    @SerializedName("field_id")
    val id: Int,
    val hint: String,
    @SerializedName("field_type")
    val fieldType: FieldType,
    val keyboard: KeyboardType? = null,
    val required: Boolean,
    @SerializedName("is_active")
    val isActive: Boolean,
    val icon: String
)

enum class KeyboardType{
    @SerializedName("text")
    TEXT,
    @SerializedName("number")
    NUMBER
}

enum class FieldType{
    @SerializedName("input")
    INPUT,
    @SerializedName("chooser")
    CHOOSER
}




