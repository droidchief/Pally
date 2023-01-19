package com.victorloveday.pally

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform