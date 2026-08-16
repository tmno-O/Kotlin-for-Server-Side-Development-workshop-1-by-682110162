import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidateCitizenIdTest {

    @Test
    fun `test normalizeCitizenId converts Thai digits to Arabic digits`() {
        val thaiInput = "๑๒๓๔๕๖๗๘๙๐๑๒๓"
        val expected = "1234567890123"
        assertEquals(expected, normalizeCitizenId(thaiInput))
    }

    @Test
    fun `test normalizeCitizenId handles mixed digits`() {
        val mixedInput = "123๔๕๖789๐๑23"
        val expected = "1234567890123"
        assertEquals(expected, normalizeCitizenId(mixedInput))
    }

    @Test
    fun `test validateCitizenId with valid Thai digits`() {
        val input = "๑๒๓๔๕๖๗๘๙๐๑๒๓"
        assertTrue(validateCitizenId(input), "Should return true for valid 13 Thai digits")
    }

    @Test
    fun `test validateCitizenId with empty or blank string`() {
        assertFalse(validateCitizenId(""), "Should return false for empty string")
        assertFalse(validateCitizenId("             "), "Should return false for blank string")
    }

    @Test
    fun `test validateCitizenId with invalid length`() {
        assertFalse(validateCitizenId("๑๒๓๔๕๖๗๘๙๐๑๒"), "Should return false when less than 13 digits")
        assertFalse(validateCitizenId("๑๒๓๔๕๖๗๘๙๐๑๒๓๔"), "Should return false when more than 13 digits")
    }

    @Test
    fun `test validateCitizenId with non-digit characters`() {
        assertFalse(validateCitizenId("๑๒๓๔๕๖๗๘๙๐๑๒ก"), "Should return false when containing letters")
        assertFalse(validateCitizenId("๑๒๓๔๕๖-๗๘๙๐๑๒"), "Should return false when containing special characters")
    }
}