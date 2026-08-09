fun main() {

    while (true) {
        // 1. แสดงเมนูให้ผู้ใช้เลือก
        println("===== Unit Converter =====")
        println("โปรดเลือกหน่วยที่ต้องการแปลง:")
        println("1. Celsius to Fahrenheit")
        println("2. Kilometers to Miles")
        println("พิมพ์ 'exit' เพื่อออกจากโปรแกรม")
        print("เลือกเมนู (1, 2, or exit): ")


        val choice = readln()


        when (choice) {
            "1" -> convertCelsiusToFahrenheit()
            "2" -> convertKilometersToMiles()
            "exit" -> {
                println("ออกจากโปรแกรม...")
                break
            }
            else -> println("ตัวเลือกไม่ถูกต้อง กรุณาลองใหม่อีกครั้ง")
        }

        println() // พิมพ์บรรทัดว่างเพื่อความสวยงาม
    }
}


fun celsiusToFahrenheit(celsius: Double): Double = celsius * 9.0 / 5.0 + 32


fun kilometersToMiles(kilometers: Double): Double = kilometers * 0.621371

fun convertCelsiusToFahrenheit() {
    print("ป้อนค่าองศาเซลเซียส (Celsius): ")
    val input = readln()

    // 5. จัดการ Null Safety ด้วย toDoubleOrNull() และ Elvis operator (?:)
    val celsius = input.toDoubleOrNull() ?: run {
        println("ข้อผิดพลาด: กรุณากรอกตัวเลขที่ถูกต้อง")
        return
    }

    val fahrenheitResult = celsiusToFahrenheit(celsius)

    println("ผลลัพธ์: $celsius °C เท่ากับ ${"%.2f".format(fahrenheitResult)} °F")
}


fun convertKilometersToMiles() {
    print("ป้อนค่ากิโลเมตร (Kilometers): ")
    val input = readln()

    val kilometers = input.toDoubleOrNull() ?: run {
        println("ข้อผิดพลาด: กรุณากรอกตัวเลขที่ถูกต้อง")
        return
    }

    val milesResult = kilometersToMiles(kilometers)

    println("ผลลัพธ์: $kilometers km เท่ากับ ${"%.2f".format(milesResult)} miles")
}