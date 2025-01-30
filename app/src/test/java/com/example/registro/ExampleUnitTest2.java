package com.example.registro;

import org.json.JSONException;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.example.registro.data.model.Message;
import org.json.JSONObject;

public class ExampleUnitTest2 {

    @Test
    public void Test1CreateLoginMessageWithUsername() throws Exception {
        // Mock JSONObject
        JSONObject mockPayload = Mockito.mock(JSONObject.class);
        when(mockPayload.has("username")).thenReturn(true);
        when(mockPayload.getString("username")).thenReturn("testUser");
        when(mockPayload.has("password")).thenReturn(true);
        when(mockPayload.getString("password")).thenReturn("testPassword");

        // Create the message
        Message message = new Message(Message.ACTION_LOGIN, mockPayload);

        assertNotNull(message);
        assertEquals(Message.ACTION_LOGIN, message.getAction());

        JSONObject payload = message.getPayload();
        assertTrue(payload.has("username"));
        assertEquals("testUser", payload.getString("username"));
        assertTrue(payload.has("password"));
        assertEquals("testPassword", payload.getString("password"));
    }

    @Test
    public void Test2CreateLoginMessageWithUsernameInput() throws JSONException {
        // Arrange
        String username = "user123";
        String password = "securePass";

        JSONObject mockPayload = Mockito.mock(JSONObject.class);
        when(mockPayload.has("username")).thenReturn(true);
        when(mockPayload.getString("username")).thenReturn(username);
        when(mockPayload.has("password")).thenReturn(true);
        when(mockPayload.getString("password")).thenReturn(password);

        // Act
        Message message = new Message(Message.ACTION_LOGIN, mockPayload);

        // Assert
        assertNotNull(message);
        assertEquals(Message.ACTION_LOGIN, message.getAction());

        JSONObject payload = message.getPayload();
        assertTrue(payload.has("username"));
        assertEquals(username, payload.getString("username"));
        assertTrue(payload.has("password"));
        assertEquals(password, payload.getString("password"));
    }

    @Test
    public void Test3CreateLoginMessageWithEmailInput() throws JSONException {
        // Arrange
        String email = "user@example.com";
        String password = "securePass";

        JSONObject mockPayload = Mockito.mock(JSONObject.class);
        when(mockPayload.has("email")).thenReturn(true);
        when(mockPayload.getString("email")).thenReturn(email);
        when(mockPayload.has("password")).thenReturn(true);
        when(mockPayload.getString("password")).thenReturn(password);

        // Act
        Message message = new Message(Message.ACTION_LOGIN, mockPayload);

        // Assert
        assertNotNull(message);
        assertEquals(Message.ACTION_LOGIN, message.getAction());

        JSONObject payload = message.getPayload();
        assertTrue(payload.has("email"));
        assertEquals(email, payload.getString("email"));
        assertTrue(payload.has("password"));
        assertEquals(password, payload.getString("password"));
    }
}
