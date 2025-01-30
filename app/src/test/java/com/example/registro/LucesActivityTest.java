package com.example.registro.ui.domotic;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.registro.R;
import com.example.registro.data.service.LightService;
import com.example.registro.ui.menu.MenuPrincipal;
import com.google.android.material.snackbar.Snackbar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(AndroidJUnit4.class)
public class LucesActivityTest {

    @Mock
    private LightService lightService;

    private ActivityScenario<LucesActivity> scenario;

    @Before
    public void setUp() {
        // Inicializar los mocks
        MockitoAnnotations.openMocks(this);

        // Iniciar la actividad
        scenario = ActivityScenario.launch(LucesActivity.class);
    }

    @Test
    public void testButtonClickTogglesStateAndUpdatesAppearance() {
        scenario.onActivity(activity -> {
            // Obtener el botón de prueba (por ejemplo, el botón del baño principal)
            Button btnBanoPrincipal = activity.findViewById(R.id.btnBanoPrincipal);

            // Simular el clic en el botón
            btnBanoPrincipal.performClick();

            // Verificar que el estado del botón ha cambiado
            assertTrue(activity.getLightStates()[0]); // El estado del botón en la posición 0 debería ser true

            // Verificar que la apariencia del botón ha cambiado
            assertEquals(Color.GREEN, btnBanoPrincipal.getBackground().getColor());
            assertEquals(Color.WHITE, btnBanoPrincipal.getTextColors().getDefaultColor());

            // Simular otro clic para volver al estado inicial
            btnBanoPrincipal.performClick();

            // Verificar que el estado del botón ha vuelto a su estado original
            assertFalse(activity.getLightStates()[0]); // El estado del botón en la posición 0 debería ser false

            // Verificar que la apariencia del botón ha vuelto a su estado original
            assertEquals(Color.WHITE, btnBanoPrincipal.getBackground().getColor());
            assertEquals(Color.BLACK, btnBanoPrincipal.getTextColors().getDefaultColor());
        });
    }

    @Test
    public void testMenuButtonStartsMenuPrincipalActivity() {
        scenario.onActivity(activity -> {
            // Obtener el botón del menú
            ImageButton menuButton = activity.findViewById(R.id.myImageButton);

            // Simular el clic en el botón del menú
            menuButton.performClick();

            // Verificar que se inició la actividad MenuPrincipal
            Intent expectedIntent = new Intent(activity, MenuPrincipal.class);
            Intent actualIntent = activity.getIntent();
            assertTrue(actualIntent.filterEquals(expectedIntent));
        });
    }

    @Test
    public void testLightServiceCalledOnButtonClick() {
        scenario.onActivity(activity -> {
            // Inyectar el mock de LightService en la actividad
            activity.setLightService(lightService);

            // Obtener el botón de prueba (por ejemplo, el botón del baño principal)
            Button btnBanoPrincipal = activity.findViewById(R.id.btnBanoPrincipal);

            // Simular el clic en el botón
            btnBanoPrincipal.performClick();

            // Verificar que el método controlLight del LightService fue llamado
            verify(lightService, times(1)).controlLight(eq("BanoPrincipal"), eq(true), any());
        });
    }
}