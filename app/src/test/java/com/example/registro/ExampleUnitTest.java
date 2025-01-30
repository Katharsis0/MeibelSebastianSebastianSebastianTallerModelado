package com.example.registro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;

import androidx.test.core.app.ActivityScenario;

import com.example.registro.ui.auth.registro.TerminosCondiciones;
import com.example.registro.ui.auth.registro.SignUpActivity;

public class ExampleUnitTest {

    private ActivityScenario<TerminosCondiciones> scenario;

    @Before
    public void setUp() {
        // Iniciar la actividad antes de cada prueba
        scenario = ActivityScenario.launch(TerminosCondiciones.class);
    }

    @After
    public void tearDown() {
        // Cerrar la actividad después de cada prueba
        if (scenario != null) {
            scenario.close();
        }
    }

    @Test
    public void testCheckBoxInitiallyDisabled() {
        scenario.onActivity(activity -> {
            CheckBox checkBox = activity.findViewById(R.id.check1);
            assertFalse("El CheckBox debería estar deshabilitado inicialmente", checkBox.isEnabled());
        });
    }

    @Test
    public void testCheckBoxEnabledAfterScrollingToBottom() {
        scenario.onActivity(activity -> {
            ScrollView scrollView = activity.findViewById(R.id.scrollView);
            CheckBox checkBox = activity.findViewById(R.id.check1);

            // Simular el scroll hasta el final
            scrollView.post(() -> scrollView.fullScroll(ScrollView.FOCUS_DOWN));

            // Verificar que el CheckBox está habilitado
            assertTrue("El CheckBox debería habilitarse después de desplazarse hasta el final", checkBox.isEnabled());
        });
    }

    @Test
    public void testContinuarButtonStartsSignUpActivityWhenCheckBoxIsChecked() {
        scenario.onActivity(activity -> {
            Button continuarButton = activity.findViewById(R.id.Continuar);
            CheckBox checkBox = activity.findViewById(R.id.check1);

            // Simular el scroll hasta el final para habilitar el CheckBox
            ScrollView scrollView = activity.findViewById(R.id.scrollView);
            scrollView.post(() -> scrollView.fullScroll(ScrollView.FOCUS_DOWN));

            // Simular que el CheckBox está marcado
            checkBox.setChecked(true);

            // Simular el clic en el botón Continuar
            continuarButton.performClick();

            // Verificar que se inició la actividad SignUpActivity
            Intent expectedIntent = new Intent(activity, SignUpActivity.class);
            Intent actualIntent = activity.getIntent();
            assertTrue("La actividad SignUpActivity debería iniciarse", actualIntent.filterEquals(expectedIntent));
        });
    }

}