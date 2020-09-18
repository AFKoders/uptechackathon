package com.afkoders.uptechackathon.presentation.login

import android.app.Activity.RESULT_CANCELED
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.afkoders.uptechackathon.R
import com.afkoders.uptechackathon.presentation.base.BaseFragmentImpl
import com.afkoders.uptechackathon.presentation.login.model.User
import com.erkutaras.showcaseview.ShowcaseManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment :
    BaseFragmentImpl<LoginAgreement.Presenter, LoginAgreement.View>(R.layout.fragment_login),
    LoginAgreement.View {
    lateinit var mGoogleSignInClient: GoogleSignInClient

    @RequiresApi(Build.VERSION_CODES.M)
    override fun setupInputs() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
        val account = GoogleSignIn.getLastSignedInAccount(requireActivity())

        if (account != null) {
            //    navigateToMainScreen()
        }

        sign_in_button.bindClick {
            signIn()
        }

        tvSignin.bindClick { signIn() }

        val builder: ShowcaseManager.Builder = ShowcaseManager.Builder()
        textView4.postDelayed({
            builder.context(requireContext())
                .key("KEY")
                .developerMode(true)
                .view(textView4)
                .descriptionImageRes(R.mipmap.ic_launcher)
                .descriptionTitle("LOREM IPSUM")
                .descriptionText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                .buttonText("Done")
                .buttonVisibility(true)
                .cancelButtonVisibility(true)
                .alphaBackground(50)
                .cancelButtonColor(Color.GREEN)
                .add()
                .build()
                .show()
        }, 2000)
    }

    private fun navigateToMainScreen() {
        findNavController().navigate(R.id.action_to_main_fragment)
    }

    private fun signIn() {
        val signInIntent = mGoogleSignInClient.getSignInIntent()
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun handleSignInResult(result: GoogleSignInAccount?) {
        updateUserPrefs(result)
        navigateToMainScreen()
    }


    private fun updateUserPrefs(account: GoogleSignInAccount?) {
        var user = User(
            account?.account?.name ?: "",
            account?.givenName ?: "",
            account?.familyName ?: "",
            account?.email ?: "",
            account?.id ?: "",
            account?.photoUrl?.normalizeScheme().toString(),
            99
        )
        presenter.saveUserToPrefs(user)
    }

    override fun showLoading() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_CANCELED) {
            if (requestCode == RC_SIGN_IN) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                handleSignInResult(task.result)
            }
        }
    }

    override fun returnThisHerePlease(): LoginAgreement.View = this

    companion object {
        const val RC_SIGN_IN = 111
    }
}

