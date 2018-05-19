package me.phum.pocketigl

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_session.*

class SessionActivity : AppCompatActivity() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    val context = this;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session)
        if (firebaseAuth.currentUser == null) {
            Snackbar.make(root, "Not signed in!", Snackbar.LENGTH_INDEFINITE).show()
        }

        //Uncomment the section below to navigate to the MapActivity using the 'Create New Section' button
/*        val button1 = findViewById<Button>(R.id.createButton)

        button1.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View): Unit {
                // Handler code here.
                val intent = Intent(context, MapActivity::class.java);
                startActivity(intent);
            }
        })*/

    }

}