package com.example.registro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.registro.ui.auth.registro.TerminosCondiciones;

public class ExampleUnitTest {
    private TerminosCondiciones terminosCondiciones;

    @Before
    public void setUp() {
        terminosCondiciones = new TerminosCondiciones();
    }

    @After
    public void tearDown() {
        terminosCondiciones = null;
    }

    @Test
    public void Test1CheckBoxInitiallyDisabled() {
        assertFalse("El checkbox debe estar deshabilitado al inicio", terminosCondiciones.isCheckBoxEnabled());
    }

    @Test
    public void Test2CheckBoxEnabledAfterScroll() {
        terminosCondiciones.simulateScrollToBottom();
        assertTrue("El checkbox debe habilitarse después de hacer scroll", terminosCondiciones.isCheckBoxEnabled());
    }

    @Test
    public void Test3NavigationToSignUpActivity() {
        terminosCondiciones.simulateScrollToBottom();
        terminosCondiciones.setCheckBoxChecked(true);
        assertTrue("Debe permitir la navegación si el checkbox está marcado", terminosCondiciones.canNavigateToSignUp());
    }
}
