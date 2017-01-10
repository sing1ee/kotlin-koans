package iii_conventions

import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) {
    infix operator fun  compareTo(date2: MyDate): Int {
        if (this.year != date2.year) return this.year - date2.year
        if (this.month != date2.month) return this.month - date2.month
        return this.dayOfMonth - date2.dayOfMonth
    }

    infix operator fun  plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    infix operator fun  contains(date: MyDate): Boolean {
        return start < date && date < endInclusive
    }

    operator fun  iterator(): Iterator<MyDate>  = object : Iterator<MyDate> {
        var curr: MyDate = start

        override fun hasNext(): Boolean {
            return curr <= endInclusive
        }

        override fun next(): MyDate {
            if (!hasNext()) {
                throw NoSuchElementException()
            }

            val result = curr
            curr = curr.nextDay()
            return result
        }
    }
}
