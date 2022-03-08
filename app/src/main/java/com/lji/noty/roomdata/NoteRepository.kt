package com.lji.noty.roomdata

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {
    val readNotes: LiveData<List<Note>> = noteDao.readNotes()

    suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }

}