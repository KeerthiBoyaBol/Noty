package com.lji.noty.models
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lji.noty.Note
import io.realm.Realm
import java.util.*

class NodeViewModel : ViewModel() {
    private var realm: Realm = Realm.getDefaultInstance()

    val allNotes: LiveData<List<Note>>
        get() = getAllNotes()

    fun addNote(noteTitle: String, noteDescription: String) {
        realm.executeTransaction { r: Realm ->
            val note = r.createObject(Note::class.java, UUID.randomUUID().toString())
            note.title = noteTitle
            note.description = noteDescription
            realm.insertOrUpdate(note)
        }
    }

    private fun getAllNotes(): MutableLiveData<List<Note>> {
        val list = MutableLiveData<List<Note>>()
        val notes = realm.where(Note::class.java).findAll()
        list.value = notes?.subList(0, notes.size)
        Log.e("what I go ", list.value.toString())
        return list
    }
}