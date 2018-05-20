package me.phum.pocketigl.lobby


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_lobby.*

import me.phum.pocketigl.R

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments!!.let {
            sessionCode = it.getString(ARG_SESSION_CODE)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lobby, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        session_id.text = sessionCode
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
