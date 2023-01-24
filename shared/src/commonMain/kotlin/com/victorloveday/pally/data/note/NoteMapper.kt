package com.victorloveday.pally.data.note

import com.victorloveday.pally.domain.note.Note
import database.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 *Created by Victor Loveday on 1/24/23
 */

fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        title = title,
        content = content,
        colorHex = colorHex,
        dateCreated = Instant
            .fromEpochMilliseconds(dateCreated)
            .toLocalDateTime(TimeZone.currentSystemDefault())
    )
}