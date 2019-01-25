package com.amthuc.nauan.congthuc.data.test

interface A {
    fun foo() { print("A") }
    fun bar()
}

interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

class C : A {
    override fun bar() { print("bar") }
}

class D : A, B {

    override fun bar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun foo() {
        super<A>.foo();
        super<B>.foo();
    }

}