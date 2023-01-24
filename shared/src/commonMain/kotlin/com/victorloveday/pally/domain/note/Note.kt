package com.victorloveday.pally.domain.note

import com.victorloveday.pally.presentation.*
import kotlinx.datetime.LocalDateTime

/**
 *Created by Victor Loveday on 1/23/23
 */
data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val contentColor: Long,
    val dateCreated: LocalDateTime
) {
    companion object {
        private val colors = listOf(RedOrangeHex, RedPinkHex, BabyBlueHex, VioletHex, LightGreenHex)

        fun generateRandomColour() = colors.random()
    }
}
