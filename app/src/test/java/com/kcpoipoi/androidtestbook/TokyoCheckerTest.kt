package com.kcpoipoi.androidtestbook

import org.assertj.core.api.Assertions.*
import org.assertj.core.api.SoftAssertions
import org.junit.After
import org.junit.Before
import org.junit.Test

//import org.junit.Assert.*

class TokyoCheckerTest {
    lateinit var target: TokyoChecker

    @Before
    fun setUp() {
        target = TokyoChecker()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun isTokyo() {
        SoftAssertions().apply {
            assertThat("TOKYO")
                .`as`("Text Check TOKYO")
                .isEqualTo("TOKYO")
                .isEqualToIgnoringCase("tokyo")
                .isNotEqualTo("KYOTO")
                .isNotBlank
                .startsWith("TO")
                .endsWith("YO")
                .contains("KY")
                .matches("[A-Z]{5}")
                .isInstanceOf(String::class.java)
        }.assertAll()
    }
}