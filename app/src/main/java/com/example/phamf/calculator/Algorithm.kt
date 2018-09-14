package com.example.phamf.calculator

import android.util.Log

fun String.removeAllSpace () = replace(" ", "")

fun String.processMinus () : String {
    var result = ""

    var list = split("-")

    for ((index, value) in list.withIndex()) {
        if (value.isNotEmpty()) {
            result = result.plus(value)
            if (index < list.size - 1) {
                result = if (value[value.lastIndex].isDigit()) {
                    result.plus("+-")
                } else {
                    result.plus("-")
                }
            }
        }
    }

    return result
}

fun String.processSQUARE () : String {

    if (contains("^2")) {

        var list : List<String> = split("^2")

        var result = ""

        for ((index, value) in list.withIndex()) {
            if (value.isNotEmpty()) {
                if (index < list.lastIndex) {
                     for (i in value.lastIndex downTo 0) {
                        if (i == 0) {
                            if (value[0].isDigit() || (value[0] == '-')) {
                                result += value.toFloat() * value.toFloat()
                            } else {
                                var number = value.substring(1, value.length)
                                result += value.removeRange(value.length - number.length, value.length) + Math.pow(number.toDouble(), 2.0).toString()
                            }
                        } else {
                            if (!value[i].isDigit() && (value[i] != '-') && (value[i] != '.')) {
                                var number = value.substring(i + 1, value.length)
                                result += value.removeRange(value.length - number.length, value.length) + Math.pow(number.toDouble(), 2.0).toString()
                                break
                            }
                        }
                    }
                } else if (index == list.lastIndex) {
                    result += value
                }
            }
        }

        return result
    }

   return this
}

fun process (content : String) : String {

    var list : ArrayList<String> = getContentInParenthese(content)

    var s : String = content

    var value: Float

    if (list.size > 0) {
        for (exp in list) {
                s = if (exp.contains("("))
                         s.replace("($exp)", process(exp))
                    else{
                        s.replace("($exp)", calc_sum(exp))
                    }
        }
    }

    Log.e("S ", s)

    value = calc_sum(s).toFloat()

    if (value % 1 == 0f) {
        return value.toInt().toString()
    }

    return value.toString()
}

fun calc_sum (exp : String) : String{

    var result = 0f
    var content = exp

    if (content.contains("^2")) content = content.processSQUARE()

    Log.e("Content is ", content)

    var p_list : List<String> = content.split("+")

    for (exp in p_list) {
        result += if (exp.contains("*") || exp.contains("/"))
            multi(exp)
        else
        {
            exp.toFloat()
        }

    }

    Log.e("result of $content is ", result.toString())

    return result.toString()
}

fun multi (s : String) : Float {
    var list : List<String> = s.split("*")
    var value = 1f
    for (exp in list) {
        value *= if (!exp.contains("/"))
                    exp.toFloat()
                else
                    divide(exp)

    }

    return value
}

fun divide (s : String) : Float {
    var list : List<String> = s.split("/")

    var value : Float = list[0].toFloat()

    for (i in 1 until list.size) {
        value /= list[i].toFloat()
    }

    return value
}

fun getContentInParenthese (content : String) : ArrayList<String> {
    val result : ArrayList<String> = ArrayList()
    if (content.contains('(')) {
        var isInParenths = false
        var startPos = 0
        var endPos: Int
        var parenth_count = 0

        for (i in 0 until content.length) {
            val char : Char = content[i]

            if (isInParenths) {
                if (char == ')') {
                    parenth_count -= 1

                    if (parenth_count == 0) {
                        endPos = i
                        val data : String = content.substring(startPos, endPos)
                        result.add(data)
                        isInParenths = false
                    }

                } else if (char == '(') parenth_count += 1

            } else {
                if (char == '(') {
                    isInParenths = true
                    startPos = i + 1
                    parenth_count += 1
                }
            }
        }

    }

    return result
}
