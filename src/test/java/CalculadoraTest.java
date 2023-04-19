import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass(){
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2,3));
        assertEquals(0, miCalculadora.multiplica(5,0));
    }

    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws Exception {
        assertEquals(2, miCalculadora.divide(4,2));
        assertEquals(2.5, miCalculadora.divide(10,4));
        assertEquals(4, miCalculadora.divide(10,2.5));
        assertEquals(3.2, miCalculadora.divide(8,2.5));
        assertEquals(0.5, miCalculadora.divide(2,4));
    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws Exception {
        assertTrue(miCalculadora.divide(4,2) > 0);
        assertTrue(miCalculadora.divide(4,-2)< 0);
        assertTrue(miCalculadora.divide(-4,2) < 0);
        assertTrue(miCalculadora.divide(-4,-2) > 0);
    }

    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.divide(5,0);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }

    @Test
    @DisplayName("sumas de numeros")
    public void testSuma() {
        assertEquals(13,miCalculadora.suma(6.5,6.5));
        assertEquals(-1,miCalculadora.suma(-0.5,-0.5));
        assertEquals(10,miCalculadora.suma(5,5));
        assertEquals(6.7,miCalculadora.suma(6,0.7));
    }

    @Test
    @DisplayName("restas de numeros")
    public void testResta() {
        assertEquals(2, miCalculadora.resta(5, 3));
        assertEquals(7.3, miCalculadora.resta(10, 2.7));
        assertEquals(4.5, miCalculadora.resta(5, 0.5));
        assertEquals(0, miCalculadora.resta(10, 10));
    }



    @Test
    @DisplayName("Potencias")
    public void testPotencia() {

        assertEquals(1, miCalculadora.potencia(5, 0));
        assertEquals(25, miCalculadora.potencia(5, 2));
        assertEquals(256, miCalculadora.potencia(4, 4));
        assertEquals(1024, miCalculadora.potencia(2, 10));


    }

 @Test
 @DisplayName("Raices Cuadradas")
    public void testRaices() throws Exception {
         assertEquals(4,miCalculadora.raizCuadrada(16));
         assertEquals(5,miCalculadora.raizCuadrada(25));
         assertEquals(1,miCalculadora.raizCuadrada(1));
         assertEquals(0,miCalculadora.raizCuadrada(0));
 }
}

