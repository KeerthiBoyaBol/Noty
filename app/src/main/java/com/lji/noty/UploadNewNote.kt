package com.lji.noty

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lji.noty.databinding.FragmentUploadNewNoteBinding
import com.lji.noty.models.NodeViewModel
import com.lji.noty.roomdata.Note
import com.lji.noty.roomdata.NoteviewModel


class UploadNewNote : Fragment() {

    private val viewModel by viewModels<NoteviewModel>()

    private var _binding: FragmentUploadNewNoteBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUploadNewNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addNote()
    }

    private fun addNote() {
        binding.apply {
            saveNote.setOnClickListener {
                val title = title.text.toString()
                val noteDesc = noteDesc.text.toString()
                if (title.isEmpty() || noteDesc.isEmpty()) {
                  // TODO add a Snack bar

                } else {
                    val note = Note(0,title,noteDesc)
                    viewModel.addNote(note)
                    findNavController().navigate(R.id.notesList)
                }

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}