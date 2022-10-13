package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.condition.JRE.JAVA_11;
import static org.junit.jupiter.api.condition.JRE.JAVA_17;

public class CondicionaisTeste {

    // @Test
    // @EnabledForJreRange(min = JAVA_11, max = JAVA_17)
    // void validarAlgoSomenteNoUsuarioWillyan() {
    // Assertions.assertEquals(10, 5 + 5);
    // }

    // @Test
    // @EnabledForJre(JAVA_11)
    // void validarAlgoSomenteNoUsuarioWillyan() {
    // Assertions.assertEquals(10, 5 + 5);
    // }

    // @Test
    // @DisabledIfEnvironmentVariable(named = "USER", matches = "Thier")
    // void validarAlgoSomenteNoUsuarioWillyan() {
    // Assertions.assertEquals(10, 5 + 5);
    // }

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "Thier")
    void validarAlgoSomenteNoUsuarioWillyan() {
        Assertions.assertEquals(10, 5 + 5);
    }

    @Test
    @EnabledOnOs({ OS.WINDOWS, OS.LINUX })
    void validarOutraCoisa() {
        Assertions.assertEquals(10, 5 + 5);
    }
}
