package com.lji.noty.roomdata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteviewModel(application: Application): AndroidViewModel(application) {

    val readNotes: LiveData<List<Note>>
    private val repository : NoteRepository

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        readNotes = repository.readNotes
    }
    fun addNote(note:Note){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(note)
        }
    }
}