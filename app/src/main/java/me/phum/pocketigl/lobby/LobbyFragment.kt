package me.phum.pocketigl.lobby


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_lobby.*
import me.phum.pocketigl.*
import java.util.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_SESSION_CODE = "arg_session_code"

/**
 * A simple [Fragment] subclass.
 * Use the [LobbyFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LobbyFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var sessionCode: String
    private var delegate : Delegate? = null
    private val Users = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments!!.let {
            sessionCode = it.getString(ARG_SESSION_CODE)
        }

    }

    private fun initRecyclerView() {
        val recyclerView = player_list
        val adapter = RecyclerViewAdapter(Users, activity)
        recyclerView.setAdapter(adapter)
        recyclerView.setLayoutManager(LinearLayoutManager(activity))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lobby, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity is Delegate) {
            delegate = activity as Delegate
        }
        session_id.text = sessionCode

        startButton.setOnClickListener {
            delegate?.onStartSession(sessionCode)
        }

        initRecyclerView()
    }

    interface Delegate {
        fun onStartSession(sessionCode: String)
    }

    companion object {
        @JvmStatic
        fun newInstance(sessionCode: String) =
                LobbyFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_SESSION_CODE, sessionCode)
                    }
                }
    }
}
