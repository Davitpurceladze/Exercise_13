package com.example.exercise_13.registration

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RegistrationViewModel : ViewModel() {

    private val jsonData = """
        [
          [
            {
              "field_id":1,
              "hint":"UserName",
              "field_type":"input",
              "keyboard":"text",
              "required":false,
              "is_active":true,
              "icon":"https://jemala.png"
            },
            {
              "field_id":2,
              "hint":"Email",
              "field_type":"input",
              "required":true,
              "keyboard":"text",
              "is_active":true,
              "icon":"https://jemala.png"
            },
            {
              "field_id":3,
              "hint":"phone",
              "field_type":"input",
              "required":true,
              "keyboard":"number",
              "is_active":true,
              "icon":"https://jemala.png"
            }
          ],
          [
            {
              "field_id":4,
              "hint":"FullName",
              "field_type":"input",
              "keyboard":"text",
              "required":true,
              "is_active":true,
              "icon":"https://jemala.png" },
            {
              "field_id":14,
              "hint":"Jemali",
              "field_type":"input",
              "keyboard":"text",
              "required":false,
              "is_active":true,
              "icon":"https://jemala.png" },
            {
              "field_id":89,
              "hint":"Birthday",
              "field_type":"chooser",
              "required":false,
              "is_active":true,
              "icon":"https://jemala.png" },
            {
              "field_id":898,
              "hint":"Gender",
              "field_type":"chooser",
              "required":false,
              "is_active":true,
              "icon":"https://jemala.png" }
          ]
        ]

        """.trimIndent()

    private var data: List<List<RegistrationDataItem>> = parseJsonData(jsonData)

    fun getData(): List<List<RegistrationDataItem>> {
        return data
    }

    private fun parseJsonData(string: String): List<List<RegistrationDataItem>> {
        val gson = Gson()
        return gson.fromJson(string, object : TypeToken<List<List<RegistrationDataItem>>>() {}.type)
    }

}