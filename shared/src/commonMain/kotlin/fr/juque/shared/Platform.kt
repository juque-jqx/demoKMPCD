package fr.juque.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform


