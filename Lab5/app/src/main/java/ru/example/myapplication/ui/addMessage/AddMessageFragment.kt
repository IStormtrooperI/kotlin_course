package ru.example.myapplication.ui.addMessage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.example.myapplication.MainActivity
import ru.example.myapplication.R
import ru.example.myapplication.adapter.SimpleAdapter
import ru.example.myapplication.databinding.FragmentAddMessageBinding
import ru.example.myapplication.databinding.FragmentQuizBinding
import ru.example.myapplication.ui.quiz.QuizViewModel

class AddMessageFragment : Fragment() {

    private val messageAdapter by lazy {
        SimpleAdapter()
    }

//    private lateinit var addMessageViewModel: AddMessageViewModel
    private var addMessageViewModel: AddMessageViewModel = AddMessageViewModel()
    private var _binding: FragmentAddMessageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val addMessageViewModel =
            ViewModelProvider(this).get(AddMessageViewModel::class.java)

        _binding = FragmentAddMessageBinding.inflate(inflater, container, false)
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

    private fun setUpUI() {

        binding.addMessage.isEnabled = false
        binding.addMessage.isClickable = false

        binding.message.addTextChangedListener {
            if(binding.message.text.toString() != "" && binding.fullName.text.toString() != ""){
                binding.addMessage.isEnabled = true
                binding.addMessage.isClickable = true
                binding.addMessage.setTextColor(0xff000000.toInt())
            } else {
                binding.addMessage.isEnabled = false
                binding.addMessage.isClickable = false
                binding.addMessage.setTextColor(0x50000000.toInt())
            }
        }

        binding.fullName.addTextChangedListener {
            if(binding.message.text.toString() != "" && binding.fullName.text.toString() != ""){
                binding.addMessage.isEnabled = true
                binding.addMessage.isClickable = true
                binding.addMessage.setTextColor(0xff000000.toInt())
            } else {
                binding.addMessage.isEnabled = false
                binding.addMessage.isClickable = false
                binding.addMessage.setTextColor(0x50000000.toInt())
            }
        }

        binding.addMessage.setOnClickListener {
            val message = binding.message.text.toString()
            val fullName = binding.fullName.text.toString()
            addMessageViewModel.addMessageModel(message, fullName)
            findNavController().navigate(R.id.action_navigation_addMessage_to_chat)
        }

//        binding.addMessage.setOnClickListener {
//            val item = messageAdapter.items.last()
//            addMessageViewModel.deleteMessageModel(item)
//        }
    }
}