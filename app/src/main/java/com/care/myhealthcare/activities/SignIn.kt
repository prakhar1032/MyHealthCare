package com.care.myhealthcare.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.Toast
import com.care.myhealthcare.R
import com.care.myhealthcare.firebase.FirestoreClass
import com.care.myhealthcare.model.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

// This is used to hide the status bar and make the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setupActionBar()

        btn_sign_in.setOnClickListener {
            signInRegisteredUser()
        }
    }

    /**
     * A function for actionBar Setup.
     */
    private fun setupActionBar() {

        setSupportActionBar(toolbar_sign_in_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_black_color_back_24dp)
        }

        toolbar_sign_in_activity.setNavigationOnClickListener { onBackPressed() }
    }
    /**
     * A function for Sign-In using the registered user using the email and password.
     */
    private fun signInRegisteredUser() {
        // Here we get the text from editText and trim the space
        val email: String = et_email.text.toString().trim { it <= ' ' }
        val password: String = et_password.text.toString().trim { it <= ' ' }

        if (validateForm(email, password)) {
            // Show the progress dialog.
            showProgressDialog(resources.getString(R.string.please_wait))

            // Sign-In using FirebaseAuth
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // TODO (Step 2: Remove the toast message and call the FirestoreClass signInUser function to get the data of user from database. And also move the code of hiding Progress Dialog and Launching MainActivity to Success function.)
                        // Calling the FirestoreClass signInUser function to get the data of user from database.
                        FirestoreClass().signInUser(this@SignIn)
                        // END
                    } else {
                        Toast.makeText(
                            this@SignIn,
                            task.exception!!.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }
    }

    // START
    /**
     * A function to validate the entries of a user.
     */
    private fun validateForm(email: String, password: String): Boolean {
        return if (TextUtils.isEmpty(email)) {
            showErrorSnackBar("Please enter email.")
            false
        } else if (TextUtils.isEmpty(password)) {
            showErrorSnackBar("Please enter password.")
            false
        } else {
            true
        }
    }
    // END

    // START
    /**
     * A function to get the user details from the firestore database after authentication.
     */
    fun signInSuccess(user: User) {

        hideProgressDialog()

        startActivity(Intent(this@SignIn, MainActivity::class.java))
        finish()
    }
    // END
}