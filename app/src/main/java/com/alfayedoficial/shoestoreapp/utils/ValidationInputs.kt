package com.alfayedoficial.shoestoreapp.utils

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.alfayedoficial.kotlinutils.KUCheckValidation.kuValidEmail
import com.alfayedoficial.kotlinutils.KUCheckValidation.kuValidPasswordContain
import com.alfayedoficial.kotlinutils.kuRes
import com.alfayedoficial.shoestoreapp.R
import com.google.android.material.textfield.TextInputEditText

object ValidationInputs {

    /**
     * @param context context for get resources
     * @param textInputEditText textInputEditText to validate
     * @param message message to show
     * @sample ValidationInputs.validateInput(context, textInputEditText, R.string.error_message_empty_field)
     * @since 1.0
     * @author Ali Al Fayed
     * @see (index of inputs) 0 -> username, 1 -> code, 2 -> password
     * @return true if the input is valid
     */
    fun Context.validationAuthTextInputEditText(vararg inputs: Pair<Int, TextInputEditText>): Boolean {
        var isValid = true
        for (input in inputs) {
            when (input.first) {
                0 -> {
                    when {
                        input.second.text.isNullOrEmpty() -> {
                            input.second.error = kuRes.getString(R.string.error_empty_field)
                            isValid = false
                        }
                        input.second.text.toString().length < 3 -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_less_character)
                            isValid = false
                        }
                        !input.second.toString().kuValidPasswordContain() -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_special_character)
                            isValid = false
                        }
                    }
                }
                1 -> {
                    when {
                        input.second.text.isNullOrEmpty() -> {
                            input.second.error = kuRes.getString(R.string.error_empty_field)
                            isValid = false
                        }
                        input.second.text.toString().length < 6 -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_less_character)
                            isValid = false
                        }
                        !input.second.toString().kuValidPasswordContain() -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_special_character)
                            isValid = false
                        }
                    }
                }
                2 -> {
                    when {
                        input.second.text.isNullOrEmpty() -> {
                            input.second.error = kuRes.getString(R.string.error_empty_field)
                            isValid = false
                        }
                        input.second.text.toString().length < 6 -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_less_character)
                            isValid = false
                        }

                    }
                }
            }
        }

        return isValid
    }

    /**
     * @param context context for get resources
     * @param textInputEditText textInputEditText to validate
     * @param message message to show
     * @sample ValidationInputs.validateInput(context, textInputEditText, R.string.error_message_empty_field)
     * @since 1.0
     * @author Ali Al Fayed
     * @see (index of inputs) 0 -> username, 1 -> code, 2 -> password
     * @return true if the input is valid
     */
    fun FragmentActivity.validationAuthTextInputEditText(vararg inputs: Pair<Int, TextInputEditText>): Boolean {
        var isValid = true
        for (input in inputs) {
            when (input.first) {
                0 -> {
                    when {
                        input.second.text.isNullOrEmpty() -> {
                            input.second.error = kuRes.getString(R.string.error_empty_field)
                            isValid = false
                        }
                        input.second.text.toString().length < 3 -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_less_character)
                            isValid = false
                        }
                        !input.second.toString().kuValidPasswordContain() -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_special_character)
                            isValid = false
                        }
                    }
                }
                1 -> {
                    when {
                        input.second.text.isNullOrEmpty() -> {
                            input.second.error = kuRes.getString(R.string.error_empty_field)
                            isValid = false
                        }
                        input.second.text.toString().length < 6 -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_less_character)
                            isValid = false
                        }
                        !input.second.toString().kuValidPasswordContain() -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_special_character)
                            isValid = false
                        }
                    }
                }
                2 -> {
                    when {
                        input.second.text.isNullOrEmpty() -> {
                            input.second.error = kuRes.getString(R.string.error_empty_field)
                            isValid = false
                        }
                        input.second.text.toString().length < 6 -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_less_character)
                            isValid = false
                        }

                    }
                }
            }
        }

        return isValid
    }

    /**
     * @param context context for get resources
     * @param textInputEditText textInputEditText to validate
     * @param message message to show
     * @sample ValidationInputs.validateInput(context, textInputEditText, R.string.error_message_empty_field)
     * @since 1.0
     * @author Ali Al Fayed
     * @see (index of inputs) 0 -> username, 1 -> code, 2 -> password
     * @return true if the input is valid
     */
    fun Fragment.validationAuthTextInputEditText(vararg inputs: Pair<Int, TextInputEditText>): Boolean {
        var isValid = true
        for (input in inputs) {
            when (input.first) {
                0 -> { // name
                    when {
                        input.second.text.isNullOrEmpty() -> {
                            input.second.error = kuRes.getString(R.string.error_empty_field)
                            input.second.requestFocus()
                            isValid = false
                        }
                        input.second.text.toString().trim().length < 3 -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_less_character)
                            input.second.requestFocus()
                            isValid = false
                        }
                        input.second.toString().kuValidPasswordContain() -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_special_character)
                            input.second.requestFocus()
                            isValid = false
                        }
                    }
                }
                1 -> { // email
                    when {
                        input.second.text.isNullOrEmpty() -> {
                            input.second.error = kuRes.getString(R.string.error_empty_field)
                            input.second.requestFocus()
                            isValid = false
                        }
                        input.second.text.toString().trim().length < 3 -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_less_character)
                            input.second.requestFocus()
                            isValid = false
                        }
                        !input.second.toString().kuValidEmail() -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_email)
                            input.second.requestFocus()
                            isValid = false
                        }
                    }
                }
                2 -> { // password
                    when {
                        input.second.text.isNullOrEmpty() -> {
                            input.second.error = kuRes.getString(R.string.error_empty_field)
                            input.second.requestFocus()
                            isValid = false
                        }
                        input.second.text.toString().trim().length < 6 -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_less_character)
                            input.second.requestFocus()
                            isValid = false
                        }

                    }
                }
            }
        }

        return isValid
    }

    /**
     * @param context context for get resources
     * @param textInputEditText textInputEditText to validate
     * @param message message to show
     * @sample ValidationInputs.validateInput(context, textInputEditText, R.string.error_message_empty_field)
     * @since 1.0
     * @author Ali Al Fayed
     * @see (index of inputs) 0 -> username, 1 -> code, 2 -> password
     * @return true if the input is valid
     */
    fun Activity.validationAuthTextInputEditText(vararg inputs: Pair<Int, TextInputEditText>): Boolean {
        var isValid = true
        for (input in inputs) {
            when (input.first) {
                0 -> {
                    when {
                        input.second.text.isNullOrEmpty() -> {
                            input.second.error = kuRes.getString(R.string.error_empty_field)
                            isValid = false
                        }
                        input.second.text.toString().length < 3 -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_less_character)
                            isValid = false
                        }
                        !input.second.toString().kuValidPasswordContain() -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_special_character)
                            isValid = false
                        }
                    }
                }
                1 -> {
                    when {
                        input.second.text.isNullOrEmpty() -> {
                            input.second.error = kuRes.getString(R.string.error_empty_field)
                            isValid = false
                        }
                        input.second.text.toString().length < 6 -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_less_character)
                            isValid = false
                        }
                        !input.second.toString().kuValidPasswordContain() -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_special_character)
                            isValid = false
                        }
                    }
                }
                2 -> {
                    when {
                        input.second.text.isNullOrEmpty() -> {
                            input.second.error = kuRes.getString(R.string.error_empty_field)
                            isValid = false
                        }
                        input.second.text.toString().length < 6 -> {
                            input.second.error = kuRes.getString(R.string.error_invalid_field_less_character)
                            isValid = false
                        }

                    }
                }
            }
        }

        return isValid
    }

    fun controlDisplayView(status:Boolean , vararg views : View ){
        for (view in views) {
            view.isEnabled = !status
        }
    }

}