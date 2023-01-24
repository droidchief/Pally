package com.victorloveday.pally.data.note

import com.victorloveday.pally.database.PallyDatabase
import com.victorloveday.pally.domain.note.Note
import com.victorloveday.pally.domain.note.NoteDataSource
import com.victorloveday.pally.domain.time.DateTimeUtil

/**
 *Created by Victor Loveday on 1/24/23
 */
class SqlDelightNoteDataSource(db: PallyDatabase): NoteDataSource {

    private val queries = db.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            dateCreated = DateTimeUtil.toEpochMillis(note.dateCreated),
            colorHex = note.colorHex
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries
            .getNoteById(id)
            .executeAsOneOrNull()
            ?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries
            .getAllNotes()
            .executeAsList()
            .map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: Long) {
        queries.deleteNote(id)
    }
}