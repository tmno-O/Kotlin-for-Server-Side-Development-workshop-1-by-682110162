fun normalizeCitizenId(id: String): String {
    return id.map { char ->
        if (char in '๐'..'๙') {
            '0' + (char - '๐')
        } else {
            char
        }
    }.joinToString("")
}

fun validateCitizenId(id: String): Boolean {
    if (id.isBlank()) return false
    val normalized = normalizeCitizenId(id)
    if (normalized.length != 13) return false
    return normalized.all { it.isDigit() }
}