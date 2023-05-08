package uz.uni_team.money_manager.common

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

//###-##-##
//123456789
fun String.getPhoneFormatter(): String {
    val builder = StringBuilder()
    for (i in this.indices){
        if ((i==4||i==8)&&this[i].code!=45){
            builder.append('-')
        }
        builder.append(i)
    }
    return builder.toString()
}

class UzbNumberVisualTransformation : VisualTransformation {

    private companion object {
        const val MAX_PHONE_LENGTH_WITH_PLUS = 13
        const val MAX_PHONE_LENGTH_WITH_TRANSFORMATION = 16
        const val UZB_PHONE_PREFIX_LENGTH = 5
    }

    override fun filter(text: AnnotatedString): TransformedText {
        //Adds '+' at the beginning of text if it does not exist
        val input = text.text
        //Checks if number input is 13 characters otherwise removes all whitespaces
        val trimmered = if (input.length >= MAX_PHONE_LENGTH_WITH_PLUS) {
            input.substring(0, MAX_PHONE_LENGTH_WITH_PLUS)
        } else input
        var output = ""
        for (i in trimmered.indices) {
            output += trimmered[i]
            //Add space between +99893 and 9999999 to make it +99893 9999999
            if (i == UZB_PHONE_PREFIX_LENGTH) output += " "
            //Add hyphens to make number +99893 999-99-99
            if (i > 7 && i != 12 && i % 2 == 0) output += "-"
        }

        val uzbNumberTranslator = object : OffsetMapping {

            override fun originalToTransformed(offset: Int): Int {
                //Log.d("uzb", "input: $input lengths: ${input.length} ---- output: $output lengths: ${output.length} ---- offset: $offset")
                if (offset <= UZB_PHONE_PREFIX_LENGTH) return offset
                if (offset <= 8) return offset + 1
                if (offset <= 10) return offset + 2
                if (offset <= 12) return offset + 3
                return MAX_PHONE_LENGTH_WITH_TRANSFORMATION
            }

            override fun transformedToOriginal(offset: Int): Int {
                if (offset <= UZB_PHONE_PREFIX_LENGTH) return offset
                if (offset <= 9) return offset - 1
                if (offset <= 12) return offset - 2
                if (offset <= 15) return offset - 3
                return MAX_PHONE_LENGTH_WITH_PLUS
            }

        }

        return TransformedText(AnnotatedString(output), uzbNumberTranslator)
    }
}