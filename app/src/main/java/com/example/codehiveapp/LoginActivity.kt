package com.example.codehiveapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.telecom.Call
import android.widget.*
import com.example.codehiveapp.Api.ApiClient
import com.example.codehiveapp.Api.ApiInterface
import com.example.codehiveapp.modules.LoginRequest
import com.example.codehiveapp.modules.LoginResponse
import org.json.JSONObject
import retrofit2.Callback
import retrofit2.Response



class LoginActivity : AppCompatActivity() {
    lateinit var etEmailLogin:EditText
    lateinit var  etPasswordLogin:EditText
    lateinit var  btnLogin:Button



    class MainActivity : AppCompatActivity() {
        lateinit var etPasswordLogin: EditText
        lateinit var etEmailLogin: EditText
        lateinit var btnLogin: Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            castViews()
        }

        fun castViews(){
            etPasswordLogin = findViewById(R.id.etPasswordLogin)
            etEmailLogin = findViewById(R.id.etEmailLogin)
            btnLogin = findViewById(R.id.btnLogin)


            clickLogin()
        }

        fun clickLogin(){
            var error = false
            btnLogin.setOnClickListener {
                var email = etEmailLogin.text.toString()
                if (email.isEmpty()) {
                    error = true
                    etEmailLogin.setError("email is required")
                }
                var password = etPasswordLogin.text.toString()
                if (password.isEmpty()){
                    error=true
                    etPasswordLogin.setError("password is required")
                }

            }

                var loginRequest = LoginRequest(
                    email=email,password=password

                )

                val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
                var request = login(LoginRequest)
                request.enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: retrofit2.Call<LoginResponse>, response: Response<LoginResponse>) {
                        if (response.isSuccessful){
                            Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG).show()
                        }
                        else{
                            try {
                                val error = JSONObject(response.errorBody()!!.string())
                                Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG)
                                    .show()
                            } catch (e: Exception) {
                                Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
                            }
                        }
                    }

                    override fun onFailure(call: retrofit2.Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })
            }
        }
    }

//    data class ApiError(var errors: List<String>)



