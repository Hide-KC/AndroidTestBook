package com.kcpoipoi.androidtestbook

import org.hamcrest.CoreMatchers.`is`
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.lang.IllegalArgumentException

@RunWith(JUnit4::class)
class InputCheckerTest {
    lateinit var target: InputChecker

    @Test
    fun isValid_givenLessThan3_returnsFalse(){
        val actual = target.isValid("ab")
        assertThat(actual, `is`(false))
    }

    @Test
    fun isValid_givenAlphabetic_returnsTrue(){
        val actual = target.isValid("abc")
        assertThat(actual, `is`(true))
    }

    @Test
    fun isValid_givenNumeric_returnsTrue(){
        val actual = target.isValid("123")
        assertThat(actual, `is`(true))
    }

    @Test
    fun isValid_givenAlphaNumeric_returnsTrue(){
        val actual = target.isValid("abc123")
        assertThat(actual, `is`(true))
    }

    @Test
    fun isValid_givenInvalidCharacter_returnsFalse(){
        val actual = target.isValid("abc*123")
        assertThat(actual, `is`(false))
    }

    @Test(expected = IllegalArgumentException::class)
    fun isValid_givenNull_throwsIllegalArgumentException(){
        target.isValid(null)
    }
        
    @Before
    fun setUp() {
        target = InputChecker()
    }

    @After
    fun tearDown() {
    }
}