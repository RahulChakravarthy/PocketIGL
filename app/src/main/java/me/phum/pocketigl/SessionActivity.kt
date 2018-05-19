package me.phum.pocketigl

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_session.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class SessionActivity : AppCompatActivity() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session)
        if (firebaseAuth.currentUser == null) {
            Snackbar.make(root, "Not signed in!", Snackbar.LENGTH_INDEFINITE).show()
        }

        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("pocketigl").child("sessions")

        createButton.setOnClickListener {
            val session = Session()
            ref.child(session.sessionCode).setValue(session)
            Snackbar.make(root, "Session code: " + session.sessionCode, Snackbar.LENGTH_LONG).show()
        }
    }

}