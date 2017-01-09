package ii_collections

fun example2(list: List<Int>) {

    val isZero: (Int) -> Boolean = { it == 0 }

    val hasZero: Boolean = list.any(isZero)

    val allZeros: Boolean = list.all(isZero)

    val numberOfZeros: Int = list.count(isZero)

    val firstPositiveNumber: Int? = list.firstOrNull { it > 0 }
}

fun Customer.isFrom(city: City): Boolean {
    // Return true if the customer is from the given city
    return this.city.name.equals(city.name)
}

fun Shop.checkAllCustomersAreFrom(city: City): Boolean {
    // Return true if all customers are from the given city
    return this.customers.filter { it.isFrom(city) }.size == this.customers.size
}

fun Shop.hasCustomerFrom(city: City): Boolean {
    // Return true if there is at least one customer from the given city
    return this.customers.filter { it.isFrom(city) }.size > 0
}

fun Shop.countCustomersFrom(city: City): Int {
    // Return the number of customers from the given city
    return this.customers.filter { it.isFrom(city) }.size
}

fun Shop.findAnyCustomerFrom(city: City): Customer? {
    // Return a customer who lives in the given city, or null if there is none
    val cs = this.customers.filter { it.isFrom(city) }
    if (cs.size > 0) {
        return cs[0]
    }
    return null
}
