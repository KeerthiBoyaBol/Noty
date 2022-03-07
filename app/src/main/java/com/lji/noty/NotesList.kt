package com.lji.noty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.lji.noty.adapters.NodeListAdapter
import com.lji.noty.databinding.FragmentNotesListBinding
import com.lji.noty.models.NodeViewModel


class NotesList : Fragment() {

    private lateinit var notesAdapter: NodeListAdapter
    private val viewModel by viewModels<NodeViewModel>()
    private var _binding: FragmentNotesListBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNotesListBinding.inflate(inflater, container, false)
        initViews()
        observeNotes()
        return binding.root

    }

    private fun observeNotes() {
        viewModel.allNotes.observe(viewLifecycleOwner) { allNotes ->
            notesAdapter.items = allNotes
        }
    }

    private fun initViews() {
        notesAdapter = NodeListAdapter()

        binding.apply {
            addNewNote.setOnClickListener {
                findNavController().navigate(R.id.uploadNewNote)
            }

            recyclerView.apply {
                addItemDecoration(DividerItemDecoration(context, 0))
                adapter = notesAdapter
            }
        }
    }
}