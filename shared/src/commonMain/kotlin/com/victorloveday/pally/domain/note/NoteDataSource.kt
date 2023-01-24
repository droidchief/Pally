package com.victorloveday.pally.domain.note

/**
 *Created by Victor Loveday on 1/24/23
 */
interface NoteDataSource {
    suspend fun insertNote(note: Note)
    suspend fun getNoteById(id: Long): Note?
    suspend fun getAllNotes(): List<Note>
    suspend fun deleteNoteById(id: Long)
}