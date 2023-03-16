package org.kata;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WrapperTestShould {
    /*
     * Casos de uso:
     *   1. columnWidth es menor o igual que 0 --done
     *   2. line está vacío o es null -- done
     *   3. columnWidth es mayor que el numero de palabras devolver la misma line -- done
     *   4. columnWidth y line son correcto, devuelve el resultado esperado
     */

    @Test
    public void giveEmptyStringIfLineIsEmpty () throws Exception {
        assertThat(Wrapper.wrap("",100)).isEqualTo("");
    }

    // Tipo de test con el expected fuera de la función
    @Test(expected = Exception.class)
    public void giveErrorIfColumnNumberIsLessThan1 () throws Exception {
        Wrapper.wrap("",0);
    }

    // Tipo de test con el expected dentro de la función
    @Test
    public void giveErrorIfColumnNumberIsLessThan1Test () throws Exception {
        Exception thrown = assertThrows(Exception.class, () -> Wrapper.wrap("",0));
        assertThat(thrown.getMessage()).isEqualTo("Column Number must be greater than 0");
    }

    @Test
    public void giveSameLineIfColumnNumberIsGreaterThanWordsNumber () throws Exception {
        assertThat(Wrapper.wrap("Buenos dias compañero",4)).isEqualTo("Buenos dias compañero");
    }

    @Test
    public void giveCorrectStringAndColumnNumberReturnCorrectSolution () throws Exception {
        assertThat(Wrapper.wrap("asd asd asd asdas dasd   asdgqw gjnqw hdfgjk kjjbsdf",4)).isEqualTo("asd asd asd asdas \n dasd   asdgqw \n gjnqw hdfgjk kjjbsdf ");
        assertThat(Wrapper.wrap("Buenos dias compañeros que tal estais todo bien ? gracias", 3)).isEqualTo("Buenos dias compañeros \n que tal estais \n todo bien ? \n gracias ");
    }
}