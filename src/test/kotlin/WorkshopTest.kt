import kotlin.test.Test
import kotlin.test.assertEquals

class WorkshopTest {

    @Test
    fun `test celsiusToFahrenheit with positive value`() {
        val celsiusInput = 20.0
        val expectedFahrenheit = 68.0

        val actualFahrenheit = celsiusToFahrenheit(celsiusInput)

        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001, "20°C should be 68°F")
    }

    @Test
    fun `test celsiusToFahrenheit with zero`() {
        val celsiusInput = 0.0
        val expectedFahrenheit = 32.0

        val actualFahrenheit = celsiusToFahrenheit(celsiusInput)

        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001, "0°C should be 32°F")
    }

    @Test
    fun `test celsiusToFahrenheit with negative value`() {
        val celsiusInput = -10.0
        val expectedFahrenheit = 14.0

        val actualFahrenheit = celsiusToFahrenheit(celsiusInput)

        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001, "-10°C should be 14°F")
    }

    @Test
    fun `test kilometersToMiles with one kilometer`() {
        val kmInput = 1.0
        val expectedMiles = 0.621371

        val actualMiles = kilometersToMiles(kmInput)

        assertEquals(expectedMiles, actualMiles, 0.000001, "1.0 km should be 0.621371 miles")
    }
}