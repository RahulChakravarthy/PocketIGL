package me.phum.pocketigl

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.InputFilter
import android.view.inputmethod.InputMethodManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_session.*
import me.phum.pocketigl.lobby.LobbyFragment


class SessionActivity : AppCompatActivity() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    private var lobbyFragment : LobbyFragment? = null
    val context = this;
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

        //Uncomment the section below to navigate to the MapActivity using the 'Create New Section' button
/*        val button1 = findViewById<Button>(R.id.createButton)

        button1.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View): Unit {
                // Handler code here.
                val intent = Intent(context, MapActivity::class.java);
                startActivity(intent);
            }
        })*/

        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("pocketigl").child("sessions")

        createButton.setOnClickListener {
            val session = Session()
            ref.child(session.sessionCode).setValue(session)
            Snackbar.make(root, "Session code: " + session.sessionCode, Snackbar.LENGTH_LONG).show()
        }
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