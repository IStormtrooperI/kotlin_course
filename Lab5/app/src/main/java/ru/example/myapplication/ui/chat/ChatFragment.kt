package ru.example.myapplication.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.button.MaterialButton
import ru.example.myapplication.R
import ru.example.myapplication.adapter.SimpleAdapter
import ru.example.myapplication.databinding.FragmentChatBinding
import ru.example.myapplication.model.MessageData

class ChatFragment : Fragment() {

    private val messageAdapter by lazy {
        SimpleAdapter()
    }

//    private lateinit var chatViewModel: ChatViewModel
    private var chatViewModel: ChatViewModel = ChatViewModel()
    private var _binding: FragmentChatBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val chatViewModel = ViewModelProvider(this).get(ChatViewModel::class.java)
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        setUpViewModel()
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpViewModel(){
        chatViewModel.observeAllMessage().observe(viewLifecycleOwner){
            messageAdapter.set(it)
        }
    }

    private fun setUpUI() {
        binding.recyclerView.apply {
            adapter = messageAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }
}