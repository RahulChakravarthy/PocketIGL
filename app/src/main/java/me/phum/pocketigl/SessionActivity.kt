package me.phum.pocketigl

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_session.*
import me.phum.pocketigl.lobby.LobbyFragment
import android.text.InputFilter
import android.view.inputmethod.InputMethodManager


class SessionActivity : AppCompatActivity() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    private var lobbyFragment : LobbyFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session)
        if (firebaseAuth.currentUser == null) {
            Snackbar.make(root, "Not signed in!", Snackbar.LENGTH_INDEFINITE).show()
        }

        joinButton.setOnClickListener {
            joinSession(sessionCodeInput.text.toString() ?: "")
            hideKeyboard()
        }

        sessionCodeInput.filters = arrayOf(InputFilter.AllCaps(), InputFilter.LengthFilter(4))

    }

    fun joinSession(sessionId: String) {
        val oldLobbyFragment = lobbyFragment
        lobbyFragment = LobbyFragment.newInstance(sessionId)
        supportFragmentManager.beginTransaction().apply {
            oldLobbyFragment?.let {
                remove(it)
            }
            add(R.id.lobby, lobbyFragment)
            commit()
        }
    }

    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
        }
    }
}