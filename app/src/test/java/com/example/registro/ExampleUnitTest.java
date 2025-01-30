package com.example.registro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.registro.ui.auth.registro.SlurChecker;

public class ExampleUnitTest {
    private SlurChecker slurChecker;

    @Before
    public void setUp() {
        slurChecker = new SlurChecker();
    }

    @After
    public void tearDown() {
        slurChecker = null;
    }

    @Test
    public void Test1ContainsEnglishSlur() {
        String textWithSlur = "IDIOT";
        assertTrue(slurChecker.containsSlur(textWithSlur));
    }

    @Test
    public void Test2ContainsSpanishSlur() {
        String textWithSlur = "idiot";
        assertTrue(slurChecker.containsSlur(textWithSlur));
    }

    @Test
    public void Test3NoSlurDetected() {
        String textWithoutSlur = "BuenDia";
        assertFalse(slurChecker.containsSlur(textWithoutSlur));
    }
}